package seoultech.startapp.festival.application;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import seoultech.startapp.festival.domain.Voting;

@Builder
@AllArgsConstructor
public class VoteResponse implements Serializable {

  private Long votingId;
  private String title;
  private String status;
  private String imgUrl;


  public static VoteResponse from(Voting voting) {
    return VoteResponse.builder()
        .votingId(voting.getVotingId())
        .title(voting.getTitle())
        .status(voting.getStatus())
        .imgUrl(voting.getImgUrl())
        .build();
  }
}
