package seoultech.startapp.festival.application;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seoultech.startapp.festival.application.port.in.GetVoteUseCase;
import seoultech.startapp.festival.application.port.out.LoadVoteSummaryPort;
import seoultech.startapp.festival.application.port.out.LoadVoterPort;
import seoultech.startapp.festival.application.port.out.LoadVotingPort;


@Service
@RequiredArgsConstructor
public class GetVotingService implements GetVoteUseCase {

  private final LoadVotingPort loadVotingPort;
  private final LoadVoterPort loadVoterPort;

  private final LoadVoteSummaryPort loadVotingSummaryPort;

  @Override
  @Transactional(readOnly = true)
  public List<VoteSummary> getVoteSummaryList(Long memberId) {
    return loadVotingSummaryPort.loadAll(memberId);
  }

  @Transactional(readOnly = true)
  @Override
  public VoteSummary getVoteSummary(Long votingId, Long memberId) {
    return loadVotingSummaryPort.loadByVotingId(votingId, memberId);
  }

  @Override
  @Transactional(readOnly = true)
  public List<VoteCountResponse> getVoteCount(Long votingId) {
    var voterList = loadVoterPort.loadAllByVotingId(votingId);

    var voteCountList = new ArrayList<VoteCountResponse>();

    voterList.forEach(voter -> voter.getVotingOptionIds().forEach(votingOptionId -> {
      var voteCount = voteCountList.stream()
          .filter(voteCountResponse -> voteCountResponse.getVotingOptionId().equals(votingOptionId))
          .findFirst();

      if (voteCount.isEmpty()) {
        voteCountList.add(new VoteCountResponse(votingOptionId, 1));
        return;
      }
      voteCount.get().setCount(voteCount.get().getCount() + 1);
    }));

    return voteCountList;
  }

}
