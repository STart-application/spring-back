package seoultech.startapp.festival.application.port.in;

import seoultech.startapp.festival.application.TruckGetResponse;
import seoultech.startapp.festival.application.TruckResponse;

import java.util.List;

public interface GetTruckUseCase {

  TruckGetResponse getAll();
  List<TruckResponse> findAll();
}
