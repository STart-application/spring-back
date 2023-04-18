package seoultech.startapp.festival.adapter.out;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "voting_option", indexes = {@Index(name = "voting_option_idx", columnList = "voting_id")})
@Getter
@NoArgsConstructor

public class JpaVotingOption {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "voting_option_id")
  private Long votingOptionId;

  @Column(name = "voting_id", nullable = false)
  private Long votingId;

  @Column(name = "option_title")
  private String optionTitle;

  @Column(name = "status")
  @Comment("투표 옵션의 상태. A: 후보, B: 당선, C: 숨김")
  private String status;

  //create_date
  @Column(name = "create_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private LocalDateTime createDate;

}
