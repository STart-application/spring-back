package seoultech.startapp.festival.application;

import java.io.Serializable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class VoteCountResponse implements Serializable {
  private Long votingOptionId;
  private int count;
}
