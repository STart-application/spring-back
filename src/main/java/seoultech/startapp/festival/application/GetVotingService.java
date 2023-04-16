package seoultech.startapp.festival.application;

import java.util.HashMap;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seoultech.startapp.festival.application.port.in.GetVoteUseCase;
import seoultech.startapp.festival.application.port.out.LoadVoterPort;
import seoultech.startapp.festival.application.port.out.LoadVotingOptionPort;
import seoultech.startapp.festival.application.port.out.LoadVotingPort;
import seoultech.startapp.festival.domain.Voter;


@Service
@RequiredArgsConstructor
public class GetVotingService implements GetVoteUseCase {

  private final LoadVotingPort loadVotePort;
  private final LoadVoterPort loadVoterPort;

  private final LoadVotingOptionPort loadVotingOptionPort;

  @Override
  public List<VoteResponse> findAll() {
    return loadVotePort.loadAll().stream().map(VoteResponse::from).toList();
  }

  @Transactional(readOnly = true)
  @Override
  public VoteDetailResponse getVoteDetail(Long votingId, Long memberId) {
    var voting = loadVotePort.loadById(votingId);
    var voter = loadVoterPort.loadByMemberIdAndVotingId(memberId, votingId)
        .orElse(new Voter());
    var votingOptions = loadVotingOptionPort.loadByVotingId(votingId);
    return VoteDetailResponse.from(voting, votingOptions, voter);
  }

  @Override
  public VoteCountResponse getVoteCount(Long votingId) {
    var voterList = loadVoterPort.loadAllByVotingId(votingId);

    var voteCount = new HashMap<Long, Integer>();

    voterList.forEach(voter ->
        voter.getVotingOptionIds()
            .forEach(optionId -> voteCount.put(optionId, voteCount.get(optionId) + 1))
    );

    return VoteCountResponse.builder()
        .voteCountList(voteCount)
        .build();
  }


}
