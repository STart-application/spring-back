package seoultech.startapp.festival.adapter.out;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "photo")
@Getter
@NoArgsConstructor
public class JpaPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photo_id")
    private int id;

    @Column(name = "photo_name")
    private String photoName;

    @Column(name = "photo_description")
    private String photoDescription;

    @Column(name = "photo_image_url")
    private String photoImageUrl;
}
