package seoultech.startapp.festival.application;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import seoultech.startapp.festival.domain.Voter;
import seoultech.startapp.festival.domain.Voting;

@Builder
@AllArgsConstructor
@Getter
public class VoteSummary implements Serializable {

  private Long votingId;
  private String title;
  private String status;
  private String imgUrl;

  private int minSelect;
  private int maxSelect;

  private List<VotingOptionSummary> voteOptionList;

  private List<Long> userSelectedOptionIds;

  public static VoteSummary from(Voting voting, Optional<Voter> voter) {
    return VoteSummary.builder()
        .votingId(voting.getVotingId())
        .title(voting.getTitle())
        .status(voting.getStatus().name())
        .imgUrl(voting.getImgUrl())
        .minSelect(voting.getMinSelect())
        .maxSelect(voting.getMaxSelect())
        .voteOptionList(
            voting.getVotingOptions().stream().map(VotingOptionSummary::fromEntity).toList())
        .userSelectedOptionIds(voter.isPresent() ? voter.get().getVotingOptionIds() : List.of())
        .build();
  }
}
