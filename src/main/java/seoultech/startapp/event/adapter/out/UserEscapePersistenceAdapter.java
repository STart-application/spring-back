package seoultech.startapp.event.adapter.out;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import seoultech.startapp.event.application.port.out.LoadUserEscapePort;
import seoultech.startapp.event.application.port.out.SaveUserEscapePort;
import seoultech.startapp.event.domain.UserEscape;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserEscapePersistenceAdapter implements LoadUserEscapePort, SaveUserEscapePort {

    private final JpaUserEscapeRepository jpaUserEscapeRepository;
    private final UserEscapeMapper mapper;

    @Override
    public List<UserEscape> loadUserEscapeListByStudentNo(String studentNo) {
        List<JpaUserEscape> jpaUserEscapeList = jpaUserEscapeRepository.findAllByStudentNo(studentNo);
//        jpaUserEscapeList
//                .orElseThrow(() -> new NotFoundJpaEventException("id에 해당하는 유저 탈출 목록이 없습니다."));

        return mapper.mapToDomainUserEscapeList(jpaUserEscapeList);
    }

    @Override
    public void saveUserEscape(UserEscape userEscape) {
        JpaUserEscape jpaUserEscape = mapper.mapToJpaUserEscape(userEscape);
        jpaUserEscapeRepository.save(jpaUserEscape);
    }
}
