package seoultech.startapp.festival.domain;

public enum StampList {
  GAME("game"),
  YARD("yard"),
  STAGE("stage"),
  BUNGEOBANG("bungeobang"),
  PHOTO("photo"),
  PRIZED("prized");

  private final String stamp;

  StampList(String stamp) {
    this.stamp = stamp;
  }


  public void validation(String target){

  }
}
