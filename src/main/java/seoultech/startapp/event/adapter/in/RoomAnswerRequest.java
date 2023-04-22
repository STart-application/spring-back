package seoultech.startapp.event.adapter.in;

import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RoomAnswerRequest {

    private final int roomId;

    private final String answer;
}
