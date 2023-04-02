package seoultech.startapp.event.application.port.in;

import org.springframework.stereotype.Component;
import seoultech.startapp.festival.application.StampResponse;
import seoultech.startapp.festival.application.port.in.command.StampCommand;

public interface RoomEscapeUseCase {

    void escape(Long userId, String target);
}
