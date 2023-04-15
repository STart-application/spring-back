package seoultech.startapp.festival.adapter.in;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seoultech.startapp.festival.application.TruckGetResponse;
import seoultech.startapp.festival.application.port.in.GetTruckUseCase;
import seoultech.startapp.global.response.JsonResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/food-trucks")
public class TruckController {

  private final GetTruckUseCase getTruckUseCase;

  @GetMapping("")
  public ResponseEntity<?> getTruckList(){

    TruckGetResponse result = getTruckUseCase.getAll();
    return JsonResponse.okWithData(HttpStatus.OK,"푸드트럭 리스트 조회를 성공했습니다.", result);
  }

}
