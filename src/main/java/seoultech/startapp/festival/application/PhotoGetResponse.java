package seoultech.startapp.festival.application;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Getter
@NoArgsConstructor
public class PhotoGetResponse implements Serializable {

  private List<PhotoResponse> photoList;

  @Builder
  public PhotoGetResponse(
      List<PhotoResponse> photoList) {
    this.photoList = photoList;
  }
}
