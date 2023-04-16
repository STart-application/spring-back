package seoultech.startapp.festival.application;

import lombok.AllArgsConstructor;
import lombok.Builder;
import seoultech.startapp.festival.domain.VotingOption;

@Builder
@AllArgsConstructor
public class VoteOptionResponse {
  private Long votingOptionId;
  private Long votingId;
  private String optionTitle;
  private String status;


  public static VoteOptionResponse from(VotingOption votingOption){
    return VoteOptionResponse.builder()
        .votingOptionId(votingOption.getVotingOptionId())
        .votingId(votingOption.getVotingId())
        .optionTitle(votingOption.getOptionTitle())
        .status(votingOption.getStatus())
        .build();
  }
}
