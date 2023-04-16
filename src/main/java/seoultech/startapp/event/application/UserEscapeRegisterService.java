package seoultech.startapp.event.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seoultech.startapp.event.application.port.in.UserEscapeRegisterUseCase;
import seoultech.startapp.event.application.port.out.LoadRoomEscapePort;
import seoultech.startapp.event.application.port.out.SaveUserEscapePort;
import seoultech.startapp.event.domain.RoomEscape;
import seoultech.startapp.event.domain.UserEscape;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserEscapeRegisterService implements UserEscapeRegisterUseCase {

    private final LoadRoomEscapePort loadRoomEscapePort;
    private final SaveUserEscapePort saveUserEscapePort;

    @Override
    @Transactional
    public SuccessEscapeResponse checkUserAnswer(String studentNo, int roomId, String userAnswer) {
        RoomEscape roomEscape = loadRoomEscapePort.loadRoomEscapeByRoomId(roomId);
        if(roomEscape.getAnswer().equals(userAnswer)) {
            UserEscape userEscape = new UserEscape(studentNo, roomId);
            saveUserEscapePort.saveUserEscape(userEscape);
            return new SuccessEscapeResponse(studentNo, roomId, true);
        }
        else
            return new SuccessEscapeResponse(studentNo, roomId, false);
    }
}
