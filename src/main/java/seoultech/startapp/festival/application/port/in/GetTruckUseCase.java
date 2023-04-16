package seoultech.startapp.festival.application.port.in;

import seoultech.startapp.festival.application.TruckListGetResponse;
import seoultech.startapp.festival.application.TruckResponse;

import java.util.List;

public interface GetTruckUseCase {

  TruckListGetResponse getAll();
  List<TruckResponse> findAll();
}
