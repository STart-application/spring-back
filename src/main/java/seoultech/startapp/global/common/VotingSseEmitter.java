package seoultech.startapp.global.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Getter
@Setter
@AllArgsConstructor
public class VotingSseEmitter {
  private Long votingId;
  private SseEmitter sseEmitter;

}
