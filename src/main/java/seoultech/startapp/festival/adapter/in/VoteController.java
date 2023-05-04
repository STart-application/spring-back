package seoultech.startapp.festival.adapter.in;

import java.util.Random;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import seoultech.startapp.festival.adapter.in.dto.RegisterVoterRequest;
import seoultech.startapp.festival.application.port.in.GetVoteUseCase;
import seoultech.startapp.festival.application.port.in.GetVoterUseCase;
import seoultech.startapp.festival.application.port.in.RegisterVoterUseCase;
import seoultech.startapp.global.common.SseEmitters;
import seoultech.startapp.global.config.web.AuthMember;
import seoultech.startapp.global.config.web.LoginMember;
import seoultech.startapp.global.response.JsonResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/vote")
public class VoteController {

  private final GetVoteUseCase getVoteUseCase;
  private final RegisterVoterUseCase registerVoterUseCase;

  private final GetVoterUseCase getVoterUseCase;

  private final SseEmitters sseEmitters;
  @GetMapping("")
  public ResponseEntity<?> getVoteList() {
    var random = new Random();
    var randomLong = random.nextLong();

    var result = getVoteUseCase.getVoteSummaryList(randomLong);
    return JsonResponse.okWithData(HttpStatus.OK, "투표 전체 조회", result);
  }

  @GetMapping("/{votingId}")
  public ResponseEntity<?> getVoteSummaryResponse(@PathVariable Long votingId, @LoginMember AuthMember member) {
    var result = getVoteUseCase.getVoteSummary(votingId, member.getMemberId());
    return JsonResponse.okWithData(HttpStatus.OK, "투표 세부 사항 조회", result);
  }

  @PostMapping("")
  public ResponseEntity<?> vote(@RequestBody RegisterVoterRequest voterRequest) {
    var random = new Random();
    var randomLong = random.nextLong();

    registerVoterUseCase.registerVoter(voterRequest.toCommand(randomLong));
    return JsonResponse.ok(HttpStatus.CREATED, "투표 성공");
  }

  @GetMapping("/count/{votingId}")
  public ResponseEntity<?> getVoteCount(@PathVariable Long votingId) {
    var result = getVoteUseCase.getVoteCount(votingId);
    return JsonResponse.okWithData(HttpStatus.OK, "투표 결과 조회", result);
  }

  @GetMapping(value = "/connect/{votingId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public ResponseEntity<SseEmitter> connect(@PathVariable Long votingId, HttpServletResponse response) {
    response.setHeader("X-Accel-Buffering", "no");
    response.setHeader("connection", "close");
    SseEmitter emitter = new SseEmitter(60 * 1000L);
    sseEmitters.add(votingId, emitter);

    return ResponseEntity.ok(emitter);
  }
}