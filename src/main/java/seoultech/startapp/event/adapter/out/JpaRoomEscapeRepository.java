package seoultech.startapp.event.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaRoomEscapeRepository extends JpaRepository<JpaRoomEscape, Long> {

//    @Override
    Optional<JpaRoomEscape> findByRoomId(int roomId);
}
