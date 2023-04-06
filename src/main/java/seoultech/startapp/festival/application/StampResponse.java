package seoultech.startapp.festival.application;

import lombok.Builder;
import lombok.Getter;
import seoultech.startapp.festival.domain.Stamp;

@Getter
public class StampResponse {

  private Long stampId;
  private Long memberId;
  private Boolean game; //exhibition -> game
  private Boolean yard; // ground -> yard
  private Boolean stage; // fleamearket -> stage
  private Boolean bungeobang;
  private Boolean photo; // sangsang -> photo
  private Boolean isPrized;

  @Builder
  public StampResponse(Long stampId, Long memberId, Boolean game, Boolean yard,
      Boolean stage, Boolean bungeobang, Boolean photo , Boolean isPrized) {
    this.stampId = stampId;
    this.memberId = memberId;
    this.game = game;
    this.yard = yard;
    this.stage = stage;
    this.bungeobang = bungeobang;
    this.photo = photo;
    this.isPrized = isPrized;
  }

  public static StampResponse toDto(Stamp stamp){
    return StampResponse.builder()
        .stampId(stamp.getStampId())
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
