package seoultech.startapp.festival.adapter.out;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import seoultech.startapp.festival.application.port.out.LoadVotingOptionPort;
import seoultech.startapp.festival.domain.VotingOption;

@Component
@RequiredArgsConstructor
public class VotingOptionPersistenceAdapter implements LoadVotingOptionPort {

  private final JpaVotingOptionRepository jpaVotingOptionRepository;

  @Override
  public List<VotingOption> loadByVotingId(Long votingId) {
    return jpaVotingOptionRepository.findAllByVotingId(votingId).stream().map(VotingOption::fromEntity).toList();
  }
}
