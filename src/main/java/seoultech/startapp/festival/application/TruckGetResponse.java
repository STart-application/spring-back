package seoultech.startapp.festival.application;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Getter
@NoArgsConstructor
public class TruckGetResponse implements Serializable {

  private List<TruckResponse> truckList;

  @Builder
  public TruckGetResponse(
      List<TruckResponse> truckList) {
    this.truckList = truckList;
  }
}
