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


@Service
@RequiredArgsConstructor
public class GetVotingService implements GetVoteUseCase {

  private final LoadVotingPort loadVotingPort;
  private final LoadVoterPort loadVoterPort;

  private final LoadVotingOptionPort loadVotingOptionPort;

  @Override
  @Transactional(readOnly = true)
  public List<VoteResponse> findAll() {
    return loadVotingPort.loadAll().stream().map(VoteResponse::from).toList();
  }

  @Transactional(readOnly = true)
  @Override
  public VoteDetailResponse getVoteDetail(Long votingId, Long memberId) {
    var voting = loadVotingPort.loadById(votingId);
    var voter = loadVoterPort.loadByMemberIdAndVotingId(memberId, votingId);
    var votingOptions = loadVotingOptionPort.loadByVotingId(votingId);
    return VoteDetailResponse.from(voting, votingOptions, voter);
  }

  @Override
  @Transactional(readOnly = true)
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
