package seoultech.startapp.event.application.port.out;

import seoultech.startapp.event.domain.RoomEscape;

import java.util.List;

public interface LoadRoomEscapePort {

    List<RoomEscape> loadRoomEscapeAll();

    RoomEscape loadRoomEscapeByRoomId(int roomId);
}
