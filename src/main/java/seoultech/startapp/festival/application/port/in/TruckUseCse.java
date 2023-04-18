package seoultech.startapp.festival.application.port.in;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.transaction.annotation.Transactional;
import seoultech.startapp.festival.application.port.in.command.RegisterTruckCommand;

public interface TruckUseCse {

  void register(RegisterTruckCommand command);

    @CacheEvict(value = "festival", allEntries = true)
    @Transactional
    void delete(int truckId);
}
