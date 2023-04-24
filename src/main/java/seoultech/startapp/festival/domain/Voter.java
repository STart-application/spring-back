package seoultech.startapp.festival.domain;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import seoultech.startapp.festival.adapter.out.JpaVoter;

@Builder
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class Voter {

  private Long votingId;
  private Long memberId;
  private LocalDateTime voteDate;

  private List<Long> votingOptionIds;

  public static Voter fromEntity(JpaVoter jpaVoter) {
    if (Objects.isNull(jpaVoter)) {
      return null;
    }
    return Voter.builder()
        .votingId(jpaVoter.getVotingId())
        .memberId(jpaVoter.getMemberId())
        .voteDate(jpaVoter.getVoteDate())
        .votingOptionIds(
            Objects.isNull(jpaVoter.getVotingOptionIds()) ?
                List.of()
                : Arrays.stream(jpaVoter.getVotingOptionIds().split(","))
                    .map(Long::parseLong).toList())
        .build();
  }

  public JpaVoter toEntity() {
    return JpaVoter.builder()
        .votingId(votingId)
        .memberId(memberId)
        .voteDate(voteDate)
        .votingOptionIds(String.join(",", votingOptionIds.stream().map(String::valueOf).toList()))
        .build();
  }
}
