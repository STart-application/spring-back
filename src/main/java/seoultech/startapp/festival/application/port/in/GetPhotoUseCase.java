package seoultech.startapp.festival.application.port.in;

import seoultech.startapp.festival.application.PhotoListGetResponse;
import seoultech.startapp.festival.application.PhotoResponse;

import java.util.List;

public interface GetPhotoUseCase {

  PhotoListGetResponse getAll();
  List<PhotoResponse> findAll();
}
