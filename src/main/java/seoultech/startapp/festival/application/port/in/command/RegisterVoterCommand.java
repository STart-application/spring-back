package seoultech.startapp.festival.application.port.in.command;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import seoultech.startapp.global.common.SelfValidator;

@Getter
@EqualsAndHashCode(callSuper = false)
public class RegisterVoterCommand extends SelfValidator<RegisterVoterCommand> {

}
