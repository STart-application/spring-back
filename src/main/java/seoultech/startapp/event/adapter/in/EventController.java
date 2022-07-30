package seoultech.startapp.event.adapter.in;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seoultech.startapp.event.application.port.EventResponse;
import seoultech.startapp.event.application.port.in.EventCommand;
import seoultech.startapp.event.application.port.in.EventGetUseCase;
import seoultech.startapp.event.application.port.in.EventPostUseCase;
import seoultech.startapp.global.response.JsonResponse;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
class EventController {

    private final EventGetUseCase eventGetUseCase;
    private final EventPostUseCase eventPostUseCase;

    @GetMapping("{id}")
    public ResponseEntity<?> getEventById(@PathVariable("id") Long eventId){
        EventResponse eventResponse = eventGetUseCase.getEventOne(eventId);
        return JsonResponse.okWithData(HttpStatus.OK,"아이디에 해당하는 이벤트를 찾았습니다.",eventResponse);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllEvent(){
        List<EventResponse> allEvent = eventGetUseCase.getAllEvent();
        return JsonResponse.okWithData(HttpStatus.OK,"모든 이벤트를 찾았습니다.",allEvent);
    }

    @PostMapping("")
    public ResponseEntity<?> registerEvent(@RequestBody @Valid EventRequest eventRequest){
        //auth 용 이벤트 올리기, 추후에 auth로 이동 예정
        EventCommand eventCommand = EventCommand.builder()
                                         .title(eventRequest.getTitle())
                                         .formLink(eventRequest.getFormLink())
                                         .imageUrl(eventRequest.getImageUrl())
                                         .startTime(eventRequest.getStartTime())
                                         .endTime(eventRequest.getEndTime())
                                         .build();
        eventPostUseCase.registerPost(eventCommand);
        return JsonResponse.ok(HttpStatus.CREATED,"이벤트를 생성했습니다.");
    }

}
