package seoultech.startapp.festival.application.port.in;

import java.util.List;
import seoultech.startapp.festival.application.VoteCountResponse;
import seoultech.startapp.festival.application.VoteSummary;

public interface GetVoteUseCase {

  List<VoteSummary> getVoteSummaryList(Long memberId);
  VoteSummary getVoteSummary(Long votingId, Long memberId);

  List<VoteCountResponse> getVoteCount(Long votingId);
}
