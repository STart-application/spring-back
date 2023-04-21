package seoultech.startapp.event.adapter.out;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "user_escape")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class JpaUserEscape {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_escape_id")
    private Long id;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "room_id")
    private int roomId;

    @Column(name = "create_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createDate;
}
