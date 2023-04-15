package seoultech.startapp.festival.adapter.in;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seoultech.startapp.festival.application.PhotoGetResponse;
import seoultech.startapp.festival.application.TruckGetResponse;
import seoultech.startapp.festival.application.port.in.GetPhotoUseCase;
import seoultech.startapp.festival.application.port.in.GetTruckUseCase;
import seoultech.startapp.global.response.JsonResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/photo-zones")
public class PhotoController {

  private final GetPhotoUseCase getPhotoUseCase;

  @GetMapping("")
  public ResponseEntity<?> getPhotoList(){

    PhotoGetResponse result = getPhotoUseCase.getAll();
    return JsonResponse.okWithData(HttpStatus.OK,"포토존 리스트 조회를 성공했습니다.", result);
  }

}
