package seoultech.startapp.festival.application;

import java.util.Map;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
public class VoteCountResponse {
  Map<Long, Integer> voteCountList;
}
