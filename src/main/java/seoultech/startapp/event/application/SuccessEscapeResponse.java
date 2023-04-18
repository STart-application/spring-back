package seoultech.startapp.event.application;

import lombok.Getter;
import seoultech.startapp.event.domain.RoomEscape;

@Getter
public class SuccessEscapeResponse {

    private boolean isAnswer;

    public SuccessEscapeResponse(boolean isAnswer) {
        this.isAnswer = isAnswer;
    }
}