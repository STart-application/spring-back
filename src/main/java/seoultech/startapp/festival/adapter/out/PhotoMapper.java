package seoultech.startapp.festival.adapter.out;

import org.springframework.stereotype.Component;
import seoultech.startapp.festival.domain.Photo;

@Component
public class PhotoMapper {

    public Photo toPhoto(JpaPhoto jpaPhoto) {
        return Photo.builder()
                .photoId(jpaPhoto.getId())
                .photoName(jpaPhoto.getPhotoName())
                .photoDescription(jpaPhoto.getPhotoDescription())
                .photoImageUrl(jpaPhoto.getPhotoImageUrl())
                .build();
    }

}
