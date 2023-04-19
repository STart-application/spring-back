package seoultech.startapp.festival.application.port.out;

import java.util.List;
import seoultech.startapp.festival.application.VoteSummary;

public interface LoadVoteSummaryPort {
  List<VoteSummary> loadAll(Long memberId);
  VoteSummary loadByVotingId(Long votingId, Long memberId);
}
