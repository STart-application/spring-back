package seoultech.startapp.festival.application.port.out;

import seoultech.startapp.festival.domain.Photo;

public interface SavePhotoPort {

  void savePhoto(Photo photo);
}
