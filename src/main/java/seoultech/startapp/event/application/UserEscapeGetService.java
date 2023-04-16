package seoultech.startapp.event.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seoultech.startapp.event.application.port.in.UserEscapeGetUseCase;
import seoultech.startapp.event.application.port.out.LoadUserEscapePort;
import seoultech.startapp.event.domain.UserEscape;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserEscapeGetService implements UserEscapeGetUseCase {

    private final LoadUserEscapePort loadUserEscapePort;

    @Override
    @Transactional(readOnly = true)
    public UserEscapeResponse getRecentUserEscape(String studentNo) {
        List<UserEscape> userEscapeList = loadUserEscapePort.loadUserEscapeListByStudentNo(studentNo);
        if (userEscapeList.isEmpty()) {
            return new UserEscapeResponse(studentNo, 0);
        } else {
            UserEscape recentUserEscape = getRecentUserEscape(userEscapeList);
            return UserEscapeResponse.userEscapeToUserEscapeResponse(recentUserEscape);
        }
    }

    private static UserEscape getRecentUserEscape(List<UserEscape> userEscapeList) {
        UserEscape recentUserEscape = userEscapeList.get(0);
        for (UserEscape userEscape : userEscapeList) {
            if (recentUserEscape.getRoomId()<userEscape.getRoomId())
                recentUserEscape = userEscape;
        }
        return recentUserEscape;
    }

}
