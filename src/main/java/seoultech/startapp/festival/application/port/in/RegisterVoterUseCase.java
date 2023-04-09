package seoultech.startapp.festival.application.port.in;

import seoultech.startapp.festival.application.port.in.command.RegisterVoterCommand;

public interface RegisterVoterUseCase {
  void registerVoter(RegisterVoterCommand command);
}
