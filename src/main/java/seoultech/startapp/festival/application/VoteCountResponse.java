package seoultech.startapp.festival.application;

import java.util.HashMap;
import java.util.Map;
import lombok.Builder;

@Builder
public class VoteCountResponse {
  Map<Long, Integer> voteCountList = new HashMap<>();
}
