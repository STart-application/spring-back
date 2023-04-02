package seoultech.startapp.event.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seoultech.startapp.event.application.port.in.RoomEscapeUseCase;
import seoultech.startapp.event.application.port.out.RoomEscapePort;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoomEscapeService implements RoomEscapeUseCase {

    private final RoomEscapePort roomEscapePort;

    @Override
    @Transactional
    public void escape(Long userId, String roomName) {
        roomEscapePort.userEscapeRoom(userId, roomName);
    }


}
