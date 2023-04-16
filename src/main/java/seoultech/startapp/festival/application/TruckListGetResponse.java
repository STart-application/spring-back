package seoultech.startapp.festival.application;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Getter
@NoArgsConstructor
public class TruckListGetResponse implements Serializable {

  private List<TruckResponse> truckList;

  @Builder
  public TruckListGetResponse(List<TruckResponse> truckList) {
    this.truckList = truckList;
  }
}
