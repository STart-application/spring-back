package seoultech.startapp.event.application;

import lombok.Getter;
import seoultech.startapp.event.domain.RoomEscape;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class RoomQuestionResponse {

    private int roomId;

    private String imageUrl;

    public static ArrayList<RoomQuestionResponse> roomEscapeListToRoomQuestionResponseList(List<RoomEscape> roomEscapeList) {

        ArrayList<RoomQuestionResponse> list = new ArrayList<>();
        for (RoomEscape roomEscape  : roomEscapeList) {
            RoomQuestionResponse roomQuestionResponse = new RoomQuestionResponse();
            roomQuestionResponse.roomId = roomEscape.getRoomId();
            roomQuestionResponse.imageUrl = roomEscape.getQuestionImageUrl();
            list.add(roomQuestionResponse);
        }
        return list;
    }
}
