package seoultech.startapp.festival.adapter.out;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity(name = "voter")
@Getter
@NoArgsConstructor
@IdClass(JpaVoterId.class)
public class JpaVoter {

  @Id
  @Comment("투표 아이디 voting tabe의 id")
  @Column(name = "voting_id")
  private Long votingId;

  @Id
  @Comment("회원 아이디 member table의 id")
  @Column(name = "member_id")
  private Long memberId;

  @Column(name = "vote_date")
  @Comment("투표 날짜")
  private LocalDateTime voteDate;

  @Column(name = "voting_option_ids")
  @Comment("투표 옵션 아이디 voting_option table의 id list")
  private String votingOptionIds;


  @Builder
  public JpaVoter(Long votingId, Long memberId, LocalDateTime voteDate, String votingOptionIds) {
    this.votingId = votingId;
    this.memberId = memberId;
    this.voteDate = voteDate;
    this.votingOptionIds = votingOptionIds;
  }

}
