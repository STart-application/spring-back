package seoultech.startapp.festival.adapter.in.dto;

import java.util.List;
import seoultech.startapp.festival.application.port.in.command.RegisterVoterCommand;

public record RegisterVoterRequest(Long votingId, List<Long> votingOptionIds){
  public RegisterVoterCommand toCommand(Long memberId){
    return RegisterVoterCommand.builder()
        .votingId(votingId)
        .memberId(memberId)
        .votingOptionIds(votingOptionIds)
        .build();
  }
}
