package seoultech.startapp.event.application;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import seoultech.startapp.event.domain.RoomEscape;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class RoomQuestionResponse {

    private int roomId;

    private String imageUrl;

    public static List<RoomQuestionResponse> roomEscapeListToRoomQuestionResponseList(List<RoomEscape> roomEscapeList) {
        List<RoomQuestionResponse> list = new ArrayList<>();
        for (RoomEscape roomEscape  : roomEscapeList) {
            RoomQuestionResponse roomQuestionResponse = RoomQuestionResponse.builder()
                    .roomId(roomEscape.getRoomId())
                    .imageUrl(roomEscape.getQuestionImageUrl())
                    .build();
            list.add(roomQuestionResponse);
        }
        return list;
    }
}
