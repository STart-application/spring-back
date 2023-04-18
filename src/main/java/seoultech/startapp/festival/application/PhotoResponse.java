package seoultech.startapp.festival.application;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import seoultech.startapp.festival.domain.Photo;
import seoultech.startapp.festival.domain.Truck;

import java.io.Serializable;

@Getter
@NoArgsConstructor
public class PhotoResponse implements Serializable {

  private int photoId;

  private String photoName;

  private String photoDescription;

  private String photoImageUrl;

  @Builder
  public PhotoResponse(int photoId, String photoName,
                       String photoDescription, String photoImageUrl) {
    this.photoId = photoId;
    this.photoName = photoName;
    this.photoDescription = photoDescription;
    this.photoImageUrl = photoImageUrl;
    }

  public static PhotoResponse toDto(Photo photo) {
    return PhotoResponse.builder()
        .photoId(photo.getPhotoId())
        .photoName(photo.getPhotoName())
        .photoDescription(photo.getPhotoDescription())
        .photoImageUrl(photo.getPhotoImageUrl())
        .build();
  }
}
