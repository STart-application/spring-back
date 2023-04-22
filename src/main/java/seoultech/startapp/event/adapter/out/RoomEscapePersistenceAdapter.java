package seoultech.startapp.event.adapter.out;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import seoultech.startapp.event.application.port.out.LoadRoomEscapePort;
import seoultech.startapp.event.domain.RoomEscape;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class RoomEscapePersistenceAdapter implements LoadRoomEscapePort {

    private final JpaRoomEscapeRepository jpaRoomEscapeRepository;
    private final RoomEscapeMapper mapper;

    @Override
    public List<RoomEscape> loadRoomEscapeAll() {
        List<JpaRoomEscape> roomEscapes = jpaRoomEscapeRepository.findAll();
        List<RoomEscape> roomEscapeList = mapper.mapToDomainRoomEscapeList(roomEscapes);
        return roomEscapeList;
    }

    @Override
    public RoomEscape loadRoomEscapeByRoomId(int roomId) {
        JpaRoomEscape jpaRoomEscape = jpaRoomEscapeRepository.findByRoomId(roomId)
                .orElseThrow(() -> new NotFoundJpaEventException("room id에 해당하는 이벤트가 없습니다."));
        return mapper.mapToDomainRoomEscape(jpaRoomEscape);
    }

}
