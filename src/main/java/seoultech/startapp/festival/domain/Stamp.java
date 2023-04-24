package seoultech.startapp.festival.domain;

import lombok.Builder;
import lombok.Getter;
import seoultech.startapp.festival.exception.AlreadyPrizedException;
import seoultech.startapp.festival.exception.AlreadyStampException;
import seoultech.startapp.festival.exception.RequireStampException;

@Getter
public class Stamp {

  private Long stampId;
  private Long memberId;
  private Boolean game;
  private Boolean yard;
  private Boolean stage;
  private Boolean bungeobang;
  private Boolean photo;
  private Boolean isPrized;

  @Builder
  public Stamp(Long stampId, Long memberId, Boolean game, Boolean yard,
      Boolean stage, Boolean bungeobang, Boolean photo, Boolean isPrized) {
    this.stampId = stampId;
    this.memberId = memberId;
    this.game = game;
    this.yard = yard;
    this.stage = stage;
    this.bungeobang = bungeobang;
    this.photo = photo;
    this.isPrized = isPrized;
  }

  public void addStamp(StampList target) {
    switch (target) {
      case GAME -> setGame(true);
      case YARD -> setYard(true);
      case STAGE -> setStage(true);
      case BUNGEOBANG -> setBungeobang(true);
      case PHOTO -> setPhoto(true);
      case PRIZED -> setPrized(true);
    }
  }

  public void setPrized(Boolean prized) {
    if(this.isPrized){
      throw new AlreadyPrizedException("이미 상품을 받았습니다.");
    }
    this.isPrized = prized;
  }

  public static Stamp initStamp(Long memberId) {
    return Stamp.builder()
        .memberId(memberId)
        .game(false)
        .stage(false)
        .yard(false)
        .bungeobang(false)
        .photo(false)
        .isPrized(false)
        .build();
  }

  public void validationPrizedStamp() {
    validationRequireStamp(this.game);
    validationRequireStamp(this.yard);
    validationRequireStamp(this.stage);
    validationRequireStamp(this.bungeobang);
    validationRequireStamp(this.photo);
  }

  private void validationRequireStamp(Boolean target) {
    if (!target) {
      throw new RequireStampException("다른 스탬프를 받아야 합니다.");
    }
  }

  private void validationAlreadyStamp(Boolean target) {
    if (target) {
      throw new AlreadyStampException("이미 찍은 스탬프입니다.");
    }
  }

  private void setGame(Boolean game) {
    validationAlreadyStamp(this.game);
    this.game = game;
  }

  private void setYard(Boolean yard) {
    validationAlreadyStamp(this.yard);
    this.yard = yard;
  }

  private void setStage(Boolean stage) {
    validationAlreadyStamp(this.stage);
    this.stage = stage;
  }

  private void setBungeobang(Boolean bungeobang) {
    validationAlreadyStamp(this.bungeobang);
    this.bungeobang = bungeobang;
  }

  private void setPhoto(Boolean photo) {
    validationAlreadyStamp(this.photo);
    this.photo = photo;
  }
}
