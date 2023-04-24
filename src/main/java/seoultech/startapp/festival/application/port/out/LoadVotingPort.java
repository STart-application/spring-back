package seoultech.startapp.festival.application.port.out;

import java.util.List;
import seoultech.startapp.festival.domain.Voting;

public interface LoadVotingPort {
  List<Voting> loadAll();

  Voting loadById(Long votingId);
}
