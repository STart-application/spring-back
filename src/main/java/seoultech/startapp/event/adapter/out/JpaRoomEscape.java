package seoultech.startapp.event.adapter.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import seoultech.startapp.global.converter.BooleanToYNConverter;
import javax.persistence.*;

@Entity(name = "room_escape")
@Getter
@NoArgsConstructor
public class JpaRoomEscape {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_escape_id")
    private Long id;

    @Column(name = "member_id", unique = true)
    private Long memberId;

    @Column(nullable = false)
//    @Convert(converter = BooleanToYNConverter.class)
    private Boolean oneEscape;

    @Column(nullable = false)
    private Boolean twoEscape;

    @Column(nullable = false)
    private Boolean threeEscape;

    @Column(nullable = false)
    private Boolean fourEscape;

    @Column(nullable = false)
    private Boolean fiveEscape;

    @Column(nullable = false)
    private Boolean sixEscape;

    @Column(nullable = false)
    private Boolean sevenEscape;

    @Column(nullable = false)
    private Boolean eightEscape;

    @Builder
    public JpaRoomEscape(Long id, Long memberId, Boolean oneEscape, Boolean twoEscape, Boolean threeEscape,
                         Boolean fourEscape, Boolean fiveEscape, Boolean sixEscape, Boolean sevenEscape, Boolean eightEscape) {
        this.id = id;
        this.memberId = memberId;
        this.oneEscape = oneEscape;
        this.twoEscape = twoEscape;
        this.threeEscape = threeEscape;
        this.fourEscape = fourEscape;
        this.fiveEscape = fiveEscape;
        this.sixEscape = sixEscape;
        this.sevenEscape = sevenEscape;
        this.eightEscape = eightEscape;
    }
}
