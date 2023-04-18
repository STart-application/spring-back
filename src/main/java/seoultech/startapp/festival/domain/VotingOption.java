package seoultech.startapp.festival.domain;

import lombok.Builder;
import lombok.Getter;
import seoultech.startapp.festival.adapter.out.JpaVotingOption;

@Getter
@Builder
public class VotingOption {
  private Long votingOptionId;
  private Long votingId;
  private String optionTitle;
  private String status;

  public static VotingOption fromEntity(JpaVotingOption jpaVotingOption) {
    return VotingOption.builder()
        .votingOptionId(jpaVotingOption.getVotingOptionId())
        .votingId(jpaVotingOption.getVotingId())
        .optionTitle(jpaVotingOption.getOptionTitle())
        .status(jpaVotingOption.getStatus())
        .build();
  }
}
