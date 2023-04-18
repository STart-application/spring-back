package seoultech.startapp.festival.application.port.out;

import seoultech.startapp.festival.domain.Truck;

public interface DeleteTruckPort {

  void deleteTruck(Truck truck);
}
