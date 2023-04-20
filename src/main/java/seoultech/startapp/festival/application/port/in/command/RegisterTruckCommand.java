package seoultech.startapp.festival.application.port.in.command;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;
import seoultech.startapp.festival.domain.LineUp;
import seoultech.startapp.festival.domain.Truck;
import seoultech.startapp.global.common.SelfValidator;

import javax.validation.constraints.NotBlank;

import static org.hibernate.boot.model.process.spi.MetadataBuildingProcess.build;

@Getter
@EqualsAndHashCode(callSuper = false)
public class RegisterTruckCommand extends SelfValidator<RegisterTruckCommand> {

  @NotBlank
  private String truckName;
  @Nullable
  private String truckDescription;

  @NotBlank
  private String truckLocation;

  @Builder
  public RegisterTruckCommand(String truckName, String truckDescription, String truckLocation) {
    this.truckName = truckName;
    this.truckDescription = truckDescription;
    this.truckLocation = truckLocation;
    validateSelf();
  }

  public Truck toDomainTruck(){
    return Truck.builder()
            .truckName(truckName)
            .truckDescription(truckDescription)
            .truckLocation(truckLocation)
            .build();
  }
}