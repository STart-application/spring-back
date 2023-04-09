package seoultech.startapp.festival.adapter.out;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity(name = "voting")
@Getter
@NoArgsConstructor
public class JpaVoting {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "voting_id")
  private Long votingId;

  @Column(name = "title")
  private String title;


  //TODO: 실제로 필요한 컬럼인지 확인 필요
  @Column(name = "open_date")
  private LocalDateTime openDate;

  //TODO: 실제로 필요한 컬럼인지 확인 필요
  @Column(name = "close_date")
  private LocalDateTime closeDate;

  @Column(name = "status")
  @Comment("투표 상태. A: 활성, B: 비활성, C: 숨김")
  private String status;

  @Column(name = "img_url")
  private String imgUrl;

  @Column(name = "create_date")
  private LocalDateTime createDate;

}
