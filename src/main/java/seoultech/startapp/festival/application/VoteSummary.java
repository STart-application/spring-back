package seoultech.startapp.festival.application;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import seoultech.startapp.festival.adapter.out.JpaVoter;
import seoultech.startapp.festival.adapter.out.JpaVoting;
import seoultech.startapp.festival.adapter.out.JpaVotingOption;

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

  public static VoteSummary from(JpaVoting jpaVoting, List<JpaVotingOption> jpaVotingOptions, JpaVoter jpaVoter) {
    return VoteSummary.builder()
        .votingId(jpaVoting.getVotingId())
        .title(jpaVoting.getTitle())
        .status(jpaVoting.getStatus())
        .imgUrl(jpaVoting.getImgUrl())
        .minSelect(jpaVoting.getMinSelect())
        .maxSelect(jpaVoting.getMaxSelect())
        .voteOptionList(jpaVotingOptions.stream().map(VotingOptionSummary::fromEntity).toList())
        .userSelectedOptionIds(
            Objects.isNull(jpaVoter.getVotingOptionIds()) ?
                List.of()
                : Arrays.stream(jpaVoter.getVotingOptionIds().split(","))
                    .map(Long::parseLong).toList()
        )
        .build();
  }
}
