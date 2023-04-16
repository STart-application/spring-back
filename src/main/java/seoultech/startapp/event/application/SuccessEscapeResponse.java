package seoultech.startapp.event.application;

import lombok.Getter;
import seoultech.startapp.event.domain.RoomEscape;

@Getter
public class SuccessEscapeResponse {

    private String studentNo;

    private int roomId;

    private boolean isAnswer;

    public SuccessEscapeResponse(String  studentNo, int roomId, boolean isAnswer) {
        this.studentNo = studentNo;
        this.roomId = roomId;
        this.isAnswer = isAnswer;
    }
}