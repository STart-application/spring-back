package seoultech.startapp.festival.application;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class VoteOptionResponse {
  private Long votingOptionId;
  private Long votingId;
  private String optionTitle;
  private String status;

}
