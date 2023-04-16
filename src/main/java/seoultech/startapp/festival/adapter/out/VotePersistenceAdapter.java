package seoultech.startapp.festival.adapter.out;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import seoultech.startapp.festival.application.port.out.LoadVotingPort;
import seoultech.startapp.festival.domain.Voting;
import seoultech.startapp.festival.exception.NotFoundVotingException;

@Component
@RequiredArgsConstructor
public class VotePersistenceAdapter implements LoadVotingPort {

  JpaVotingRepository jpaVotingRepository;

  @Override
  public List<Voting> loadAll() {
    return jpaVotingRepository.findAllByStatusIsNot("HIDDEN").stream().map(Voting::fromEntity)
        .toList();
  }

  @Override
  public Voting loadById(Long votingId) {
    return Voting.fromEntity(
        jpaVotingRepository.findById(votingId)
            .orElseThrow(() -> new NotFoundVotingException("해당 투표가 없습니다."))
    );
  }
}
