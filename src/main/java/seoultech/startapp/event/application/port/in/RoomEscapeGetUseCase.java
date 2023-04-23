package seoultech.startapp.event.application.port.in;

import seoultech.startapp.event.application.RoomQuestionResponse;

import java.util.List;

public interface RoomEscapeGetUseCase {

    List<RoomQuestionResponse> getQuestionList();
}
