package seoultech.startapp.festival.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seoultech.startapp.festival.application.port.in.GetTruckUseCase;
import seoultech.startapp.festival.application.port.out.LoadTruckPort;
import seoultech.startapp.festival.domain.Truck;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetTruckService implements GetTruckUseCase {

    private final LoadTruckPort loadTruckPort;

    @Override
    public TruckListGetResponse getAll() {
        return new TruckListGetResponse(findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public List<TruckResponse> findAll() {
        List<Truck> truckList = loadTruckPort.loadListOrderById();
        return truckList.stream()
                .map(TruckResponse::toDto)
                .toList();
    }
}
