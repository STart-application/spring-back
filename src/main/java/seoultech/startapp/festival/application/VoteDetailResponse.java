package seoultech.startapp.festival.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import seoultech.startapp.festival.domain.Voter;
import seoultech.startapp.festival.domain.Voting;
import seoultech.startapp.festival.domain.VotingOption;

@Builder
@AllArgsConstructor
public class VoteDetailResponse {
  @JsonProperty("voting")
  private VoteResponse voteResponse;

  private int minSelect;
  private int maxSelect;


  private List<VoteOptionResponse> voteOptionResponseList;

  private List<Long> userSelectedOptionIds;


  public static VoteDetailResponse from(Voting voting, List<VotingOption> votingOptions, Voter voter){
    return VoteDetailResponse.builder()
        .voteResponse(VoteResponse.from(voting))
        .minSelect(voting.getMinSelect())
        .maxSelect(voting.getMaxSelect())
        .voteOptionResponseList(votingOptions.stream().map(VoteOptionResponse::from).toList())
        .userSelectedOptionIds(voter.getVotingOptionIds())
        .build();
  }
}
