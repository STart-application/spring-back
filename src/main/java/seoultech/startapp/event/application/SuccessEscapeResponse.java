package seoultech.startapp.event.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import seoultech.startapp.event.domain.RoomEscape;

@Getter
@AllArgsConstructor
public class SuccessEscapeResponse {

    private boolean isAnswer;
}