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

    @Column(name = "room_id")
    private int roomId;

    @Column(name = "question_image_url")
    private String questionImageUrl;

    @Column
    private String answer;


//    @Builder
//    public JpaRoomEscape(int id, String questionImageUrl String answer) {
//        this.id = id;
//        this.questionImageUrl = question;
//        this.answer = answer;
//
//    }
}