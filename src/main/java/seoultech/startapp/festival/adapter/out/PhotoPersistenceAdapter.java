package seoultech.startapp.festival.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import seoultech.startapp.banner.application.port.out.LoadBannerPort;
import seoultech.startapp.banner.domain.Banner;
import seoultech.startapp.festival.application.port.out.LoadPhotoPort;
import seoultech.startapp.festival.domain.Photo;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PhotoPersistenceAdapter implements LoadPhotoPort {

    private final JpaPhotoRepository jpaPhotoRepository;
    private final PhotoMapper photoMapper;

    @Override
    public List<Photo> loadListOrderById() {
        List<JpaPhoto> jpaPhotoList = jpaPhotoRepository.findAll();
        return jpaPhotoList.stream()
                .map(jpaPhoto -> photoMapper.toPhoto(jpaPhoto))
                .collect(Collectors.toList());
    }
}
