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
import javax.validation.constraints.NotNull;
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
  @NotNull
  private String title;

  @Column(name = "min_select", columnDefinition = "INT DEFAULT 1")
  @Comment("최소 선택 개수")
  private int minSelect;

  @Column(name = "max_select", columnDefinition = "INT DEFAULT 1")
  @Comment("최대 선택 개수")
  private int maxSelect;

  @Column(name = "status")
  @Comment("투표 상태. BEFORE: 투표예정, STARTED: 투표 시작됨, END: 투표 마감, HIDDEN: 투표 숨김")
  private String status;

  @Column(name = "description")
  @NotNull
  private String description;

  @Column(name = "create_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private LocalDateTime createDate;

  @Column(name = "display_start_date")
  private LocalDateTime displayStartDate;

  @Column(name = "display_end_date")
  private LocalDateTime displayEndDate;

  @OneToMany(mappedBy = "jpaVoting", fetch = LAZY)
  @JsonIgnore
  private List<JpaVotingOption> voteOptionList = List.of();
}
