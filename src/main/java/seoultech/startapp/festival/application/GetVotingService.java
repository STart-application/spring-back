package seoultech.startapp.festival.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seoultech.startapp.festival.application.port.in.GetVoteUseCase;
import seoultech.startapp.festival.application.port.out.LoadVoterPort;
import seoultech.startapp.festival.application.port.out.LoadVotingPort;
import seoultech.startapp.festival.domain.Voting;


@Service
@RequiredArgsConstructor
public class GetVotingService implements GetVoteUseCase {

  private final LoadVotingPort loadVotingPort;
  private final LoadVoterPort loadVoterPort;

  @Override
  @Transactional(readOnly = true)
  public List<VoteSummary> getVoteSummaryList(Long memberId) {
    var votingList = loadVotingPort.loadAll();
    var voterList = loadVoterPort.loadAllByMemberIdAndVotingIdList(memberId,
        votingList.stream().map(Voting::getVotingId).toList());
    return votingList.stream()
        .map(voting -> VoteSummary.from(voting,
            voterList.stream()
                .filter(voter -> voting.getVotingId().equals(voter.getVotingId()))
                .findFirst())
        )
        .toList();
  }

  @Transactional(readOnly = true)
  @Override
  public VoteSummary getVoteSummary(Long votingId, Long memberId) {
    var voting = loadVotingPort.loadById(votingId);
    var voter = loadVoterPort.loadByMemberIdAndVotingId(memberId, votingId);
    return VoteSummary.from(voting, Optional.ofNullable(voter));
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
