package seoultech.startapp.festival.adapter.in;

import java.io.IOException;
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

  SseEmitters sseEmitters;

  @GetMapping("")
  public ResponseEntity<?> getVoteList() {
    var result = getVoteUseCase.findAll();
    return JsonResponse.okWithData(HttpStatus.OK, "투표 전체 조회", result);
  }

  @GetMapping("/{votingId}")
  public ResponseEntity<?> getVoteDetail(@PathVariable Long votingId, @LoginMember AuthMember member) {
    var result = getVoteUseCase.getVoteDetail(votingId, member.getMemberId());
    return JsonResponse.okWithData(HttpStatus.OK, "투표 세부 사항 조회", result);
  }

  @PostMapping("")
  public ResponseEntity<?> vote(@RequestBody RegisterVoterRequest voterRequest, @LoginMember AuthMember member) {
    registerVoterUseCase.registerVoter(voterRequest.toCommand(member.getMemberId()));
    return JsonResponse.ok(HttpStatus.CREATED, "투표 성공");
  }


  @GetMapping(value = "/connect/{votingId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public ResponseEntity<?> connect(@PathVariable Long votingId, @LoginMember AuthMember member) {

    //멤버가 투표를 안했으면 에러 처리해야 함.

    SseEmitter emitter = new SseEmitter(60 * 1000L);
    sseEmitters.add(emitter);

    try {
      emitter.send(SseEmitter.event()
          .name("SHOW_VOTE_RESULT_"+votingId)
          .data("connected!"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return ResponseEntity.ok(emitter);
  }
}