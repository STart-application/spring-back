package seoultech.startapp.festival.application.port.out;

import java.util.List;
import java.util.Optional;
import seoultech.startapp.festival.domain.Voter;

public interface LoadVoterPort {
  Optional<Voter> loadByMemberIdAndVotingId(Long memberId, Long votingId);

  List<Voter> loadAllByVotingId(Long votingId);
}
