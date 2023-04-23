package seoultech.startapp.event.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomEscape {

    private int roomId;

    private String questionImageUrl;

    private String answer;

    public Boolean isNextRoomId(int recentEscapeRoomId) {
        if (this.roomId == recentEscapeRoomId+1) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean isRightAnswer(String userAnswer) {
        if (this.answer.equals(userAnswer)) {
            return true;
        } else {
            return false;
        }
    }
}
