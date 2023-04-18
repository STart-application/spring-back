package seoultech.startapp.festival.adapter.out;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaVotingRepository extends JpaRepository<JpaVoting, Long> {
  //find all not hidden
  public List<JpaVoting> findAllByStatusIsNot(String status);

}
