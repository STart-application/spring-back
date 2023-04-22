package seoultech.startapp.event.application.port.out;

import seoultech.startapp.event.domain.UserEscape;

import java.util.List;

public interface LoadUserEscapePort {

    List<UserEscape> loadUserEscapeListByStudentNo(Long memberId);
}
