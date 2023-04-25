package seoultech.startapp.event.application.port.out;

import seoultech.startapp.event.domain.UserEscape;

public interface SaveUserEscapePort {

    void save(UserEscape userEscape);
}
