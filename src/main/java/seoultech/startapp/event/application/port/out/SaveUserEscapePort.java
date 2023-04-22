package seoultech.startapp.event.application.port.out;

import seoultech.startapp.event.domain.Event;
import seoultech.startapp.event.domain.UserEscape;

public interface SaveUserEscapePort {

    void saveUserEscape(UserEscape userEscape);
}
