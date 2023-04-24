package seoultech.startapp.festival.application;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import seoultech.startapp.festival.adapter.out.JpaVotingOption;
import seoultech.startapp.festival.domain.VotingOption;

@Builder
@Getter
@AllArgsConstructor
public class VotingOptionSummary implements Serializable {
  private Long votingOptionId;
  private String optionTitle;
  private String status;


  public static VotingOptionSummary fromEntity(VotingOption votingOption) {
    return VotingOptionSummary.builder()
        .votingOptionId(votingOption.getVotingOptionId())
        .optionTitle(votingOption.getOptionTitle())
        .status(votingOption.getStatus())
        .build();
  }
}
