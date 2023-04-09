package seoultech.startapp.festival.domain;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class Voting {
  private long votingId;
  private String title;

  private LocalDateTime openDate;

  private LocalDateTime closeDate;

  private String status;

  private String imgUrl;

  private LocalDateTime createDate;

  private List<?> voter;
}
