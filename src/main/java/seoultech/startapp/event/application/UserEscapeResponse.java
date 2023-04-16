package seoultech.startapp.event.application;

import lombok.Getter;
import seoultech.startapp.event.domain.UserEscape;

@Getter
public class UserEscapeResponse {

    private String studentNo;
    private int roomId;

    public UserEscapeResponse(String studentNo, int roomId) {
        this.studentNo = studentNo;
        this.roomId = roomId;
    }

    public static UserEscapeResponse userEscapeToUserEscapeResponse(UserEscape userEscape) {
        UserEscapeResponse userEscapeResponse = new UserEscapeResponse(
                userEscape.getStudentNo(),
                userEscape.getRoomId()
        );
        return userEscapeResponse;
    }

}
