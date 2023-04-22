package seoultech.startapp.festival.domain;

import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;

@Getter
public class Truck {

  private int truckId;

  private String truckName;

  private String truckDescription;

  private String truckLocation;

  @Builder
  public Truck(int truckId, String truckName, String truckDescription, String truckImageUrl, String truckLocation) {
    this.truckId = truckId;
    this.truckName = truckName;
    this.truckDescription = truckDescription;
    this.truckLocation = truckLocation;
  }
}
