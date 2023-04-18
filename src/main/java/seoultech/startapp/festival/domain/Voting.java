package seoultech.startapp.festival.domain;

import java.time.LocalDateTime;
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

  private String status;

  private String imgUrl;

  private LocalDateTime createDate;

  public static Voting fromEntity(JpaVoting jpaVoting){
    return Voting.builder()
        .votingId(jpaVoting.getVotingId())
        .title(jpaVoting.getTitle())
        .minSelect(jpaVoting.getMinSelect())
        .maxSelect(jpaVoting.getMaxSelect())
        .status(jpaVoting.getStatus())
        .imgUrl(jpaVoting.getImgUrl())
        .createDate(jpaVoting.getCreateDate())
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
  }
  private boolean isNotActive(){
    return !status.equals("ACTIVE");
  }
  private boolean isHidden(){
    return status.equals("HIDDEN");
  }
  private boolean isOverSelected(int selectedCount){
    return selectedCount > maxSelect;
  }
  private boolean isUnderSelected(int selectedCount){
    return selectedCount < minSelect;
  }
}
