package seoultech.startapp.festival.application;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import seoultech.startapp.festival.domain.Voting;

@Builder
@Getter
@AllArgsConstructor
public class VoteResponse implements Serializable {

  private Long votingId;
  private String title;
  private String status;
  private String imgUrl;

  private int minSelect;
  private int maxSelect;


  public static VoteResponse from(Voting voting) {
    return VoteResponse.builder()
        .votingId(voting.getVotingId())
        .title(voting.getTitle())
        .status(voting.getStatus())
        .imgUrl(voting.getImgUrl())
        .minSelect(voting.getMinSelect())
        .maxSelect(voting.getMaxSelect())
        .build();
  }
}
