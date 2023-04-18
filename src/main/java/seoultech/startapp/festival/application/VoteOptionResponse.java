package seoultech.startapp.festival.application;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import seoultech.startapp.festival.domain.VotingOption;

@Builder
@Getter
@AllArgsConstructor
public class VoteOptionResponse implements Serializable {
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
