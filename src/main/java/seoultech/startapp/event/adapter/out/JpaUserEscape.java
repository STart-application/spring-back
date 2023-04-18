package seoultech.startapp.event.adapter.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "user_escape")
@Getter
@NoArgsConstructor
public class JpaUserEscape {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_escape_id")
    private Long id;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "room_id")
    private int roomId;

    @Builder
    public JpaUserEscape(Long id, Long memberId, int roomId) {
        this.id = id;
        this.memberId = memberId;
        this.roomId = roomId;
    }
}
