package seoultech.startapp.festival.application.port.out;

import seoultech.startapp.festival.domain.Photo;
import seoultech.startapp.festival.domain.Truck;

import java.util.List;

public interface LoadPhotoPort {

  Photo loadById(int photoId);
  List<Photo> loadListOrderById();
}
