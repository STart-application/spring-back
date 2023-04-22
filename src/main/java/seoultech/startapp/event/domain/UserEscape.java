package seoultech.startapp.event.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class UserEscape {

    private Long memberId;
    private int roomId;

    @Builder
    public UserEscape(Long memberId, int roomId) {
        this.memberId = memberId;
        this.roomId = roomId;
    }
}
