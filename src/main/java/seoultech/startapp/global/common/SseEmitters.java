package seoultech.startapp.global.common;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import seoultech.startapp.festival.application.VoteResponse;
import seoultech.startapp.festival.application.port.in.GetVoteUseCase;

@Component
@Slf4j
public class SseEmitters {
  private final GetVoteUseCase getVoteUseCase;
  private final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();

  public SseEmitters(GetVoteUseCase getVoteUseCase) {
    this.getVoteUseCase = getVoteUseCase;
  }

  public SseEmitter add(SseEmitter emitter) {
    this.emitters.add(emitter);
    log.info("new emitter added: {}", emitter);
    log.info("emitter list size: {}", emitters.size());
    emitter.onCompletion(() -> {
      log.info("onCompletion callback");
      this.emitters.remove(emitter);    // 만료되면 리스트에서 삭제
    });
    emitter.onTimeout(() -> {
      log.info("onTimeout callback");
      emitter.complete();
    });

    return emitter;
  }

  public void count() {
    var votingList = getVoteUseCase.findAll();

    var votingFindFirstIsActive = votingList.stream()
        .filter(voting -> "ACTIVE".equals(voting.getStatus()))
        .findFirst();

    if(votingFindFirstIsActive.isEmpty()) {
      return;
    }

    var votingId = votingFindFirstIsActive.get().getVotingId();

    var count = getVoteUseCase.getVoteCount(votingId);

    emitters.forEach(emitter -> {
      try {
        emitter.send(SseEmitter.event()
            .name("SHOW_VOTE_RESULT_"+votingId)
            .data(count+"\n\n"));
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    });
  }
}