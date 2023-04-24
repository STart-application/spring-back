package seoultech.startapp.festival.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seoultech.startapp.festival.application.port.in.GetLineUpUseCase;
import seoultech.startapp.festival.application.port.in.GetPhotoUseCase;
import seoultech.startapp.festival.application.port.out.LoadLineUpPort;
import seoultech.startapp.festival.application.port.out.LoadPhotoPort;
import seoultech.startapp.festival.domain.LineUp;
import seoultech.startapp.festival.domain.Photo;

@Service
@RequiredArgsConstructor
public class GetPhotoService implements GetPhotoUseCase {

  private final LoadPhotoPort loadPhotoPort;

  @Override
  public PhotoListGetResponse getAll() {
    return new PhotoListGetResponse(findAll());
  }

  @Transactional(readOnly = true)
  @Override
  public List<PhotoResponse> findAll() {
    List<Photo> photoList = loadPhotoPort.loadListOrderById();
    return photoList.stream()
            .map(PhotoResponse::toDto)
            .toList();
  }
}

