package seoultech.startapp.festival.application.port.in;

import java.util.List;
import seoultech.startapp.festival.application.VoteDetailResponse;
import seoultech.startapp.festival.application.VoteResponse;

public interface GetVoteUseCase {

  List<VoteResponse> findAll();
  VoteDetailResponse getVoteDetail(Long voteId);
}
