package seoultech.startapp.festival.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seoultech.startapp.festival.application.port.in.RegisterVoterUseCase;
import seoultech.startapp.festival.application.port.in.command.RegisterVoterCommand;
import seoultech.startapp.festival.application.port.out.LoadVotingPort;
import seoultech.startapp.festival.application.port.out.SaveVoterPort;

@Service
@RequiredArgsConstructor
public class RegisterVoterService implements RegisterVoterUseCase {

  private final SaveVoterPort saveVoterPort;

  private final LoadVotingPort loadVotingPort;
  @Override
  @Transactional
  public void registerVoter(RegisterVoterCommand command) {
    var voting = loadVotingPort.loadById(command.getVotingId());
    var voter = command.toVoter();

    //투표할 수 있는 상태인지 검사.
    voting.validateVoting(voter);

    saveVoterPort.save(voter);
  }
}
