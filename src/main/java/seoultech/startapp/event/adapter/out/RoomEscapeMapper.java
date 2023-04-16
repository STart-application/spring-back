package seoultech.startapp.event.adapter.out;

import org.springframework.stereotype.Component;
import seoultech.startapp.event.domain.RoomEscape;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoomEscapeMapper {

    public RoomEscape mapToDomainRoomEscape(JpaRoomEscape jpaRoomEscape) {
        RoomEscape roomEscape = RoomEscape.builder()
                .roomId(jpaRoomEscape.getRoomId())
                .question(jpaRoomEscape.getQuestionImageUrl())
                .answer(jpaRoomEscape.getAnswer())
                .build();
        return roomEscape;
    }

    public List<RoomEscape> mapToDomainRoomEscapeList(List<JpaRoomEscape> jpaRoomEscapesList) {
        List<RoomEscape> roomEscapeList = jpaRoomEscapesList
                .stream()
                .map(jpaRoomEscape -> mapToDomainRoomEscape(jpaRoomEscape))
                .collect(Collectors.toList());

        return roomEscapeList;
    }
}
