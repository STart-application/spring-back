package seoultech.startapp.event.application.port.out;

public interface RoomEscapePort {

    void userEscapeRoom(Long userId, String roomName);
}
