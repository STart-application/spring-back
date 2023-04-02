package seoultech.startapp.event.adapter.in;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seoultech.startapp.event.application.EventResponse;
import seoultech.startapp.event.application.port.in.RoomEscapeUseCase;
import seoultech.startapp.global.response.JsonResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/room_escape")
@Slf4j
class RoomEscapeController {

    private final RoomEscapeUseCase roomEscapeUseCase;

    @PostMapping
    public ResponseEntity<?> postUserEscape(@RequestParam Long userId, @RequestParam String roomName) {
        roomEscapeUseCase.escape(userId, roomName);
        return JsonResponse.okWithData(HttpStatus.OK,"유저가 방을 탈출했습니다.", null);
    }
}