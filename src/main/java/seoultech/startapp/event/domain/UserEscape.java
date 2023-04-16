package seoultech.startapp.event.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class UserEscape {

    private String studentNo;
    private int roomId;

    @Builder
    public UserEscape(String studentNo, int roomId) {
        this.studentNo = studentNo;
        this.roomId = roomId;
    }
}
