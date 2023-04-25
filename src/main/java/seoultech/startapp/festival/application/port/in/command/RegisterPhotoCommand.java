package seoultech.startapp.festival.application.port.in.command;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;
import seoultech.startapp.festival.domain.Photo;
import seoultech.startapp.festival.domain.Truck;
import seoultech.startapp.global.common.SelfValidator;

import javax.validation.constraints.NotBlank;

@Getter
@EqualsAndHashCode(callSuper = false)
public class RegisterPhotoCommand extends SelfValidator<RegisterPhotoCommand> {

  @NotBlank
  private String photoName;

  private String photoDescription;

  private String photoImageUrl;

  @Builder
  public RegisterPhotoCommand(String photoName, String photoDescription, String photoImageUrl) {
    this.photoName = photoName;
    this.photoDescription = photoDescription;
    this.photoImageUrl = photoImageUrl;
    validateSelf();
  }

  public Photo toDomainPhoto(){
    return Photo.builder()
            .photoName(photoName)
            .photoDescription(photoDescription)
            .photoImageUrl(photoImageUrl)
            .build();
  }
}