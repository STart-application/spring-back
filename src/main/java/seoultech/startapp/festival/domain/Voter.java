package seoultech.startapp.festival.domain;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class Voter {
  private Long votingId;
  private Long memberId;
  private LocalDateTime voteDate;

  private List<Long> votingOptionIds;

}
