package seoultech.startapp.event.application.port.in;

import seoultech.startapp.event.application.UserEscapeResponse;

public interface UserEscapeGetUseCase {

    UserEscapeResponse getRecentUserEscape(String studentNo);
}

