package seoultech.startapp.festival.application;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seoultech.startapp.festival.application.port.in.TruckUseCse;
import seoultech.startapp.festival.application.port.in.command.RegisterTruckCommand;
import seoultech.startapp.festival.application.port.out.DeleteTruckPort;
import seoultech.startapp.festival.application.port.out.LoadTruckPort;
import seoultech.startapp.festival.application.port.out.SaveTruckPort;
import seoultech.startapp.festival.domain.Truck;

@Service
@RequiredArgsConstructor
public class TruckService implements TruckUseCse {

  private final LoadTruckPort loadTruckPort;
  private final SaveTruckPort saveTruckPort;
  private final DeleteTruckPort deleteTruckPort;

  @CacheEvict(value = "festival", allEntries = true)
  @Transactional
  @Override
  public void register(RegisterTruckCommand command) {
    Truck truck = command.toDomainTruck();
    saveTruckPort.saveTruck(truck);
  }

  @Override
  public void delete(Long truckId) {

  }


  @CacheEvict(value = "festival", allEntries = true)
  @Transactional
  @Override
  public void delete(int truckId) {
    Truck truck = loadTruckPort.loadById(truckId);
    deleteTruckPort.deleteTruck(truck);
  }
}
