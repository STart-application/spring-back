package seoultech.startapp.festival.adapter.out;

import org.springframework.stereotype.Component;
import seoultech.startapp.festival.domain.Stamp;

@Component
public class StampMapper {

  public Stamp toDomainStamp(JpaStamp jpaStamp) {
    return Stamp.builder()
        .stampId(jpaStamp.getId())
        .memberId(jpaStamp.getMemberId())
        .game(jpaStamp.getGame())
        .yard(jpaStamp.getYard())
        .stage(jpaStamp.getStage())
        .bungeobang(jpaStamp.getBungeobang())
        .photo(jpaStamp.getPhoto())
        .isPrized(jpaStamp.getIsPrized())
        .build();
  }


  public JpaStamp toJapStamp(Stamp stamp) {
    return JpaStamp.builder()
        .id(stamp.getStampId() == null ? null : stamp.getStampId())
        .memberId(stamp.getMemberId())
        .game(stamp.getGame())
        .yard(stamp.getYard())
        .stage(stamp.getStage())
        .bungeobang(stamp.getBungeobang())
        .photo(stamp.getPhoto())
        .isPrized(stamp.getIsPrized())
        .build();
  }
}
