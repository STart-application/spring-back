package seoultech.startapp.event.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seoultech.startapp.event.application.port.in.UserEscapeGetUseCase;
import seoultech.startapp.event.application.port.in.UserEscapeRegisterUseCase;
import seoultech.startapp.event.application.port.out.LoadRoomEscapePort;
import seoultech.startapp.event.application.port.out.SaveUserEscapePort;
import seoultech.startapp.event.domain.RoomEscape;
import seoultech.startapp.event.domain.UserEscape;
import seoultech.startapp.global.exception.InvalidInputException;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserEscapeRegisterService implements UserEscapeRegisterUseCase {

    private final UserEscapeGetUseCase userEscapeGetUseCase;
    private final LoadRoomEscapePort loadRoomEscapePort;
    private final SaveUserEscapePort saveUserEscapePort;

    @Override
    @Transactional
    public SuccessEscapeResponse checkUserAnswer(Long memberId, int roomId, String userAnswer) {
        int recentEscapeRoomId = userEscapeGetUseCase.getRecentEscapeRoomId(memberId);
        RoomEscape roomEscape = loadRoomEscapePort.loadRoomEscapeByRoomId(roomId);
        if (roomEscape.getRoomId()-1 != recentEscapeRoomId)
            throw new InvalidInputException("요청 방 id는 올바르지 않은 요청입니다.");

        if(roomEscape.getAnswer().equals(userAnswer)) {
            UserEscape userEscape = new UserEscape(memberId, roomId);
            saveUserEscapePort.saveUserEscape(userEscape);
            return new SuccessEscapeResponse(true);
        }
        else
            return new SuccessEscapeResponse(false);
    }
}
