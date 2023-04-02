package seoultech.startapp.event.adapter.out;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import seoultech.startapp.event.application.port.out.RoomEscapePort;

@Slf4j
@Component
@RequiredArgsConstructor
public class RoomEscapePersistenceAdapter implements RoomEscapePort {

    private final JpaRoomEscape jpaRoomEscape;
    private final JpaEscapeUser jpaEscapeUser;

    @Override
    public void userEscapeRoom(Long userId, String roomName) {
        // 유저가 방 탈출 한 로직

        // 해당 유저가 모든 방을 탈출했다면  EscapeUser 에 등록
    }
}
