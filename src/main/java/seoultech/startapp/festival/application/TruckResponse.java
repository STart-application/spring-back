package seoultech.startapp.festival.application;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import seoultech.startapp.festival.domain.Truck;

import java.io.Serializable;

@Getter
@NoArgsConstructor
public class TruckResponse implements Serializable {

  private int truckId;

  private String truckName;

  private String truckDescription;

  private String truckImageUrl;
  private String truckLocation;


  @Builder
  public TruckResponse(int truckId, String truckName,
                       String truckDescription, String truckImageUrl, String truckLocation) {
    this.truckId = truckId;
    this.truckName = truckName;
    this.truckDescription = truckDescription;
    this.truckImageUrl = truckImageUrl;
    this.truckLocation = truckLocation;
  }

  public static TruckResponse toDto(Truck truck) {
    return TruckResponse.builder()
        .truckId(truck.getTruckId())
        .truckName(truck.getTruckName())
        .truckDescription(truck.getTruckDescription())
        .truckImageUrl(truck.getTruckImageUrl())
        .truckLocation(truck.getTruckLocation())
        .build();
  }
}
