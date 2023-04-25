package seoultech.startapp.festival.adapter.in.dto;

import seoultech.startapp.festival.application.port.in.command.RegisterPhotoCommand;

public record RegisterPhotoRequest(String photoName, String photoDescription, String photoImageUrl) {

  public RegisterPhotoCommand toCommand(){
    return RegisterPhotoCommand.builder()
            .photoName(photoName)
            .photoDescription(photoDescription)
            .photoImageUrl(photoImageUrl)
            .build();
  }
}
