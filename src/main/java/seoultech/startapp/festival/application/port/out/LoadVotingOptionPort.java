package seoultech.startapp.festival.application.port.out;

import java.util.List;
import seoultech.startapp.festival.domain.VotingOption;

public interface LoadVotingOptionPort {
  List<VotingOption> loadByVotingId(Long votingId);

}
