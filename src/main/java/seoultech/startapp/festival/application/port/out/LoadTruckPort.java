package seoultech.startapp.festival.application.port.out;

import seoultech.startapp.festival.domain.Truck;

import java.util.List;

public interface LoadTruckPort {

  Truck loadById(int truckId);
  List<Truck> loadListOrderById();
}
