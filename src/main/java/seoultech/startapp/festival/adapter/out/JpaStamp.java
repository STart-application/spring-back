package seoultech.startapp.festival.adapter.out;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import seoultech.startapp.global.converter.BooleanToYNConverter;

@Entity(name = "stamp")
@Getter
@NoArgsConstructor
public class JpaStamp {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "stamp_id")
  private Long id;

  @Column(name = "member_id", unique = true)
  private Long memberId;

  @Column(nullable = false)
  @Convert(converter = BooleanToYNConverter.class)
  private Boolean game;

  @Column(nullable = false)
  @Convert(converter = BooleanToYNConverter.class)
  private Boolean yard;

  @Column(nullable = false)
  @Convert(converter = BooleanToYNConverter.class)
  private Boolean stage;

  @Column(nullable = false)
  @Convert(converter = BooleanToYNConverter.class)
  private Boolean bungeobang;

  @Column(nullable = false)
  @Convert(converter = BooleanToYNConverter.class)
  private Boolean photo;

  @Column(nullable = false)
  @Convert(converter = BooleanToYNConverter.class)
  private Boolean isPrized;

  @Builder
  public JpaStamp(Long id, Long memberId, Boolean game, Boolean yard,
      Boolean stage, Boolean bungeobang, Boolean photo, Boolean isPrized) {
    this.id = id;
    this.memberId = memberId;
    this.game = game;
    this.yard = yard;
    this.stage = stage;
    this.bungeobang = bungeobang;
    this.photo = photo;
    this.isPrized = isPrized;
  }
}
