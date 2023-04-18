package seoultech.startapp.event.application.port.in;

import seoultech.startapp.event.application.RoomQuestionResponse;

import java.util.ArrayList;

public interface RoomEscapeGetUseCase {

    ArrayList<RoomQuestionResponse> getQuestionList();
}
