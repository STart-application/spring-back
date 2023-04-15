package seoultech.startapp.festival.application;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seoultech.startapp.festival.application.port.in.PhotoUseCse;
import seoultech.startapp.festival.application.port.in.TruckUseCse;
import seoultech.startapp.festival.application.port.in.command.RegisterPhotoCommand;
import seoultech.startapp.festival.application.port.in.command.RegisterTruckCommand;
import seoultech.startapp.festival.application.port.out.*;
import seoultech.startapp.festival.domain.Photo;
import seoultech.startapp.festival.domain.Truck;

@Service
@RequiredArgsConstructor
public class PhotoService implements PhotoUseCse {

  private final LoadPhotoPort loadPhotoPort;
  private final SavePhotoPort savePhotoPort;
  private final DeletePhotoPort deletePhotoPort;

  @CacheEvict(value = "festival", allEntries = true)
  @Transactional
  @Override
  public void register(RegisterPhotoCommand command) {
    Photo photo = command.toDomainPhoto();
    savePhotoPort.savePhoto(photo);
  }


  @CacheEvict(value = "festival", allEntries = true)
  @Transactional

  public void delete(int photoId) {
    Photo photo = loadPhotoPort.loadById(photoId);
    deletePhotoPort.deletePhoto(photo);
  }
}
