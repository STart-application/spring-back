package seoultech.startapp.festival.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import seoultech.startapp.festival.domain.Voter;
import seoultech.startapp.festival.domain.Voting;
import seoultech.startapp.festival.domain.VotingOption;

@Builder
@Getter
@AllArgsConstructor
public class VoteDetailResponse implements Serializable {
  @JsonProperty("voting")
  private VoteResponse voteResponse;

  private List<VoteOptionResponse> voteOptionList;

  private List<Long> userSelectedOptionIds;


  public static VoteDetailResponse from(Voting voting, List<VotingOption> votingOptions, Voter voter){
    return VoteDetailResponse.builder()
        .voteResponse(VoteResponse.from(voting))
        .voteOptionList(votingOptions.stream().map(VoteOptionResponse::from).toList())
        .userSelectedOptionIds(voter.getVotingOptionIds())
        .build();
  }
}
