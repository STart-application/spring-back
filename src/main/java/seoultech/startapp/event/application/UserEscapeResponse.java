package seoultech.startapp.event.application;

import lombok.Getter;
import seoultech.startapp.event.domain.UserEscape;

@Getter
public class UserEscapeResponse {

    private int roomId;

    public UserEscapeResponse(int roomId) {
        this.roomId = roomId;
    }
}
