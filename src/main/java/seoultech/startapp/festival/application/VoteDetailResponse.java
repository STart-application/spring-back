package seoultech.startapp.festival.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class VoteDetailResponse {
  @JsonProperty("voting")
  private VoteResponse voteResponse;

  @JsonProperty("voting_option_list")
  private List<VoteOptionResponse> voteOptionResponseList;

  private Long userSelectedOptionId;

}
