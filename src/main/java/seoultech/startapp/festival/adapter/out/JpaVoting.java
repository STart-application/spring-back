package seoultech.startapp.festival.adapter.out;

import static javax.persistence.FetchType.LAZY;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "voting")
@Getter
@NoArgsConstructor
public class JpaVoting {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "voting_id")
  private Long votingId;

  @Column(name = "title")
  private String title;

  @Column(name = "min_select")
  @Comment("최소 선택 개수")
  private int minSelect;

  @Column(name = "max_select")
  @Comment("최대 선택 개수")
  private int maxSelect;

  @Column(name = "status")
  @Comment("투표 상태. BEFORE: 투표예정, STARTED: 투표 시작됨, END: 투표 마감, HIDDEN: 투표 숨김")
  private String status;

  @Column(name = "img_url")
  private String imgUrl;

  @Column(name = "create_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private LocalDateTime createDate;

  @OneToMany(mappedBy = "jpaVoting", fetch = LAZY)
  @JsonIgnore
  private List<JpaVotingOption> voteOptionList = List.of();
}
