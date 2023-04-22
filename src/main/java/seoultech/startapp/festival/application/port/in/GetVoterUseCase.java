package seoultech.startapp.festival.application.port.in;

public interface GetVoterUseCase {
  boolean isVoted(Long votingId, Long memberId);
}
