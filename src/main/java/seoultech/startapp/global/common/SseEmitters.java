package seoultech.startapp.global.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import seoultech.startapp.festival.application.VoteCountResponse;
import seoultech.startapp.festival.application.port.in.GetVoteUseCase;

@Component
@Slf4j
public class SseEmitters {
  private final GetVoteUseCase getVoteUseCase;
  private final List<VotingSseEmitter> votingEmitters = new CopyOnWriteArrayList<>();

  public SseEmitters(GetVoteUseCase getVoteUseCase) {
    this.getVoteUseCase = getVoteUseCase;
  }

  public SseEmitter add(Long votingId, SseEmitter emitter) {
    var votingSseEmitter = new VotingSseEmitter(votingId, emitter);
    this.votingEmitters.add(votingSseEmitter);
    log.info("new emitter added: {}", emitter);
    log.info("emitter list size: {}", votingEmitters.size());
    emitter.onCompletion(() -> {
      log.info("onCompletion callback");
      this.votingEmitters.remove(votingSseEmitter);    // 만료되면 리스트에서 삭제
    });
    emitter.onTimeout(() -> {
      log.info("onTimeout callback");
      emitter.complete();
    });

    return emitter;
  }

  public void count() {
    var votingIdList = votingEmitters.stream().map(VotingSseEmitter::getVotingId).distinct().toList();

    var voteCountMap = new HashMap<Long, List<VoteCountResponse>>();

    votingIdList.forEach(votingId -> {
      var voteCountResponseList = getVoteUseCase.getVoteCount(votingId);
      voteCountMap.put(votingId, voteCountResponseList);
    });

    votingEmitters.forEach(votingEmitter -> {
      try {
        votingEmitter.getSseEmitter().send(SseEmitter.event()
            .name("SHOW_VOTE_RESULT_"+votingEmitter.getVotingId())
            .data(voteCountMap.get(votingEmitter.getVotingId())+"\n\n"));
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    });
  }
}