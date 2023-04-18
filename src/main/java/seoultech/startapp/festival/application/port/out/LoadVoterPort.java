package seoultech.startapp.festival.application.port.out;

import java.util.List;
import seoultech.startapp.festival.domain.Voter;

public interface LoadVoterPort {
  Voter loadByMemberIdAndVotingId(Long memberId, Long votingId);

  List<Voter> loadAllByVotingId(Long votingId);
}
