package seoultech.startapp.festival.domain;

public enum VotingStatus {
  BEFORE("BEFORE"),
  START("START"),
  END("END"),
  HIDDEN("HIDDEN");

  private final String status;

  VotingStatus(String status) {
    this.status = status;
  }
}
