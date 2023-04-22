package seoultech.startapp.event.adapter.out;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity(name = "room_escape")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JpaRoomEscape {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_escape_id")
    private Long id;

    @Column(name = "room_id", unique = true)
    private int roomId;

    @Column(name = "question_image_url")
    private String questionImageUrl;

    @Column
    private String answer;
}