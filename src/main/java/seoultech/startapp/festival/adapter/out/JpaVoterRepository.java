package seoultech.startapp.festival.adapter.out;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaVoterRepository extends JpaRepository<JpaVoter, Long> {
  public Optional<JpaVoter> findByMemberIdAndVotingId(Long memberId, Long votingId);

  public List<JpaVoter> findAllByVotingId(Long votingId);

  public List<JpaVoter> findAllByMemberIdAndVotingIdIn(Long memberId, List<Long> votingIdList);
}
