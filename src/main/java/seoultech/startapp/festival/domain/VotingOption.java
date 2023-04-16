package seoultech.startapp.festival.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class VotingOption {
  private Long votingOptionId;
  private Long votingId;
  private String optionTitle;
  private String status;
}
