package seoultech.startapp.event.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaUserEscapeRepository extends JpaRepository<JpaUserEscape, Long> {

    List<JpaUserEscape> findAllByMemberId(Long memberId);
}
