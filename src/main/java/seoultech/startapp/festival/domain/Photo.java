package seoultech.startapp.festival.domain;

import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;

@Getter
public class Photo {

  private int photoId;
  private String photoName;
  @Nullable
  private String photoDescription;
  @Nullable
  private String photoImageUrl;

  @Builder
  public Photo(int photoId, String photoName, String photoDescription, String photoImageUrl) {
    this.photoId = photoId;
    this.photoName = photoName;
    this.photoDescription = photoDescription;
    this.photoImageUrl = photoImageUrl;

  }
}
