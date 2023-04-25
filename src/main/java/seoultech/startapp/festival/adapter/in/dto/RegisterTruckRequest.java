package seoultech.startapp.festival.adapter.in.dto;

import seoultech.startapp.festival.application.port.in.command.RegisterTruckCommand;

import static org.hibernate.boot.model.process.spi.MetadataBuildingProcess.build;

public record RegisterTruckRequest(String truckName, String truckDescription, String truckImageUrl, String truckLocation) {

  public RegisterTruckCommand toCommand(){
    return RegisterTruckCommand.builder()
            .truckName(truckName)
            .truckDescription(truckDescription)
            .truckLocation(truckLocation)
            .build();
  }
}
