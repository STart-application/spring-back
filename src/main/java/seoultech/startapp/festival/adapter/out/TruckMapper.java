package seoultech.startapp.festival.adapter.out;

import org.springframework.stereotype.Component;
import seoultech.startapp.festival.domain.Truck;

@Component
public class TruckMapper {

    public Truck toTruck(JpaTruck jpaTruck) {
        return Truck.builder()
                .truckId(jpaTruck.getId())
                .truckName(jpaTruck.getTruckName())
                .truckDescription(jpaTruck.getTruckDescription())
                .truckImageUrl(jpaTruck.getTruckImageUrl())
                .truckLocation(jpaTruck.getTruckLocation())
                .build();
    }
}
