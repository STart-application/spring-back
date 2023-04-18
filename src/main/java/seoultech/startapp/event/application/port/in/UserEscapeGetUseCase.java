package seoultech.startapp.event.application.port.in;

import seoultech.startapp.event.application.UserEscapeResponse;

public interface UserEscapeGetUseCase {

    int getRecentEscapeRoomId(Long memberId);
}

