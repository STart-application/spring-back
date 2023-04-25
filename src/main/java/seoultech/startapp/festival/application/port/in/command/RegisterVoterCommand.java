package seoultech.startapp.festival.application.port.in.command;

import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import seoultech.startapp.festival.domain.Voter;
import seoultech.startapp.global.common.SelfValidator;

@Getter
@EqualsAndHashCode(callSuper = false)
public class RegisterVoterCommand extends SelfValidator<RegisterVoterCommand> {
  @NotNull
  Long votingId;

  @NotNull
  Long memberId;

  @NotNull
  List<Long> votingOptionIds;

  LocalDateTime voteDate;

  @Builder
  public RegisterVoterCommand(Long votingId, Long memberId, List<Long> votingOptionIds) {
    this.votingId = votingId;
    this.memberId = memberId;
    this.votingOptionIds = votingOptionIds;
    validateSelf();
  }

  public Voter toVoter(){
    return Voter.builder()
        .votingId(votingId)
        .memberId(memberId)
        .votingOptionIds(votingOptionIds)
        .voteDate(LocalDateTime.now())
        .build();
  }
}
