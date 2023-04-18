package seoultech.startapp.festival.adapter.out;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import seoultech.startapp.festival.application.port.out.LoadVoterPort;
import seoultech.startapp.festival.application.port.out.SaveVoterPort;
import seoultech.startapp.festival.domain.Voter;

@Component
@RequiredArgsConstructor
public class VoterPersistenceAdapter implements LoadVoterPort, SaveVoterPort {

  private final JpaVoterRepository jpaVoterRepository;


  @Override
  public Voter loadByMemberIdAndVotingId(Long memberId, Long votingId) {
    return Voter.fromEntity(jpaVoterRepository.findByMemberIdAndVotingId(memberId, votingId).orElse(new JpaVoter()));
  }

  @Override
  public List<Voter> loadAllByVotingId(Long votingId) {
    return jpaVoterRepository.findAllByVotingId(votingId).stream().map(Voter::fromEntity).toList();
  }

  @Override
  public void save(Voter voter) {
    jpaVoterRepository.save(voter.toEntity());
  }
}