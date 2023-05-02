package seoultech.startapp.festival.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seoultech.startapp.festival.application.port.in.GetVoterUseCase;
import seoultech.startapp.festival.application.port.out.LoadVoterPort;

@Service
@RequiredArgsConstructor
public class GetVoterService implements GetVoterUseCase {

  private final LoadVoterPort loadVoterPort;
  @Override
  public boolean isVoted(Long votingId, Long memberId) {
    return loadVoterPort.loadByMemberIdAndVotingId(memberId, votingId) != null;
  }
}
