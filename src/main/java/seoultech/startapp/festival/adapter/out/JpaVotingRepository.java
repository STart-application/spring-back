package seoultech.startapp.festival.adapter.out;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaVotingRepository extends JpaRepository<JpaVoting, Long> {
  //find all not hidden
  @Query("select distinct v from JpaVoting v join fetch v.voteOptionList where v.status <> :status")
  public List<JpaVoting> findAllByStatusIsNot(String status);

}
