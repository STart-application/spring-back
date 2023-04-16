package seoultech.startapp.event.adapter.in;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

@Getter
@RequiredArgsConstructor
public class RoomAnswerRequest {

    private String studentNo;

    private int roomId;

    private String answer;
}
