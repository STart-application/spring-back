package seoultech.startapp.event.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RoomEscape {

    private int roomId;

    private String questionImageUrl;

    private String answer;

    @Builder
    public RoomEscape(int roomId, String question, String answer) {
        this.roomId = roomId;
        this.questionImageUrl = question;
        this.answer = answer;
    }
}
