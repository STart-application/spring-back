package seoultech.startapp.festival.adapter.out;
import lombok.Getter;
import lombok.NoArgsConstructor;
import seoultech.startapp.global.converter.BooleanToYNConverter;

import javax.persistence.*;

@Entity(name = "truck")
@Getter
@NoArgsConstructor
public class JpaTruck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "truck_id")
    private int id;

    @Column(name = "truck_name")
    private String truckName;

    @Column(name = "truck_description")
    private String truckDescription;

    @Column(name = "truck_location")
    private String truckLocation;
}
