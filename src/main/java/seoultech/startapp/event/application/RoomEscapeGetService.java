package seoultech.startapp.event.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seoultech.startapp.event.application.port.in.RoomEscapeGetUseCase;
import seoultech.startapp.event.application.port.out.LoadRoomEscapePort;
import seoultech.startapp.event.domain.RoomEscape;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoomEscapeGetService implements RoomEscapeGetUseCase {

    private final LoadRoomEscapePort loadRoomEscapePort;

    @Override
    @Transactional(readOnly = true)
    public ArrayList<RoomQuestionResponse> getQuestionList() {
        List<RoomEscape> roomEscapeList = loadRoomEscapePort.loadRoomEscapeAll();
        return RoomQuestionResponse.roomEscapeListToRoomQuestionResponseList(roomEscapeList);
    }
}
