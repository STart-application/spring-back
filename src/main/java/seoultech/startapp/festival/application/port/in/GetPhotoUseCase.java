package seoultech.startapp.festival.application.port.in;

import seoultech.startapp.festival.application.PhotoGetResponse;
import seoultech.startapp.festival.application.PhotoResponse;

import java.util.List;

public interface GetPhotoUseCase {

  PhotoGetResponse getAll();
  List<PhotoResponse> findAll();
}
