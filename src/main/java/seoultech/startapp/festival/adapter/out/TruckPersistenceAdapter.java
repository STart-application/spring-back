package seoultech.startapp.festival.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import seoultech.startapp.festival.application.port.out.LoadTruckPort;
import seoultech.startapp.festival.domain.Truck;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TruckPersistenceAdapter implements LoadTruckPort {

    private final JpaTruckRepository jpaTruckRepository;
    private final TruckMapper truckMapper;

    @Override
    public List<Truck> loadListOrderById() {
        List<JpaTruck> jpaTruckList = jpaTruckRepository.findAll();
        return jpaTruckList.stream()
                .map(jpaTruck -> truckMapper.toTruck(jpaTruck))
                .collect(Collectors.toList());
    }
}
