package seoultech.startapp.event.adapter.out;

import org.springframework.stereotype.Component;
import seoultech.startapp.event.domain.UserEscape;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserEscapeMapper {

    public UserEscape mapToDomainUserEscape(JpaUserEscape jpaUserEscape) {
        UserEscape userEscape = UserEscape.builder()
                .studentNo(jpaUserEscape.getStudentNo())
                .roomId(jpaUserEscape.getRoomId())
                .build();
        return userEscape;
    }

    public List<UserEscape> mapToDomainUserEscapeList(List<JpaUserEscape> jpaUserEscapeList) {
        List<UserEscape> userEscapeList = jpaUserEscapeList
                .stream()
                .map(jpaUserEscape -> mapToDomainUserEscape(jpaUserEscape))
                .collect(Collectors.toList());
        return userEscapeList;
    }

    public JpaUserEscape mapToJpaUserEscape(UserEscape userEscape) {
        return JpaUserEscape.builder()
                .id(null)
                .studentNo(userEscape.getStudentNo())
                .roomId(userEscape.getRoomId())
                .build();
    }

}
