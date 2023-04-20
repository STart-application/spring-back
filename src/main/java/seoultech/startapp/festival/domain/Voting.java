package seoultech.startapp.festival.domain;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import seoultech.startapp.festival.exception.ValidVotingRequestException;
import seoultech.startapp.festival.adapter.out.JpaVoting;

@Getter
@Builder
public class Voting {
  private Long votingId;
  private String title;

  private int minSelect;
  private int maxSelect;

  private VotingStatus status;

  private String description;

  private LocalDateTime createDate;

  private LocalDateTime displayStartDate;

  private LocalDateTime displayEndDate;

  private List<VotingOption> votingOptions;

  public static Voting fromEntity(JpaVoting jpaVoting){
    return Voting.builder()
        .votingId(jpaVoting.getVotingId())
        .title(jpaVoting.getTitle())
        .minSelect(jpaVoting.getMinSelect())
        .maxSelect(jpaVoting.getMaxSelect())
        .status(VotingStatus.valueOf(jpaVoting.getStatus()))
        .description(jpaVoting.getDescription())
        .displayStartDate(jpaVoting.getDisplayStartDate())
        .displayEndDate(jpaVoting.getDisplayEndDate())
        .createDate(jpaVoting.getCreateDate())
        .votingOptions(jpaVoting.getVoteOptionList().stream().map(VotingOption::fromEntity).toList())
        .build();
  }

  public void validateVoting(Voter voter){
    if (isNotActive()){
      throw new ValidVotingRequestException("투표가 활성화 되지 않았습니다.");
    }
    if(isOverSelected(voter.getVotingOptionIds().size())){
      throw new ValidVotingRequestException("정해진 개수보다 많이 선택했습니다.");
    }
    if(isUnderSelected(voter.getVotingOptionIds().size())){
      throw new ValidVotingRequestException("정해진 개수보다 적게 선택했습니다.");
    }
    if (isNotValidOption(voter.getVotingOptionIds())){
      throw new ValidVotingRequestException("유효하지 않은 투표 옵션입니다.");
    }
  }
  private boolean isNotActive(){
    return !status.name().equals(VotingStatus.START.name());
  }
  private boolean isOverSelected(int selectedCount){
    return selectedCount > maxSelect;
  }
  private boolean isUnderSelected(int selectedCount){
    return selectedCount < minSelect;
  }
  private boolean isNotValidOption(List<Long> votingOptionIds){
    return votingOptions.stream()
        .noneMatch(votingOption -> votingOptionIds.contains(votingOption.getVotingOptionId()));
  }
}
