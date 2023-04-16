package seoultech.startapp.event.application.port.in;

import seoultech.startapp.event.application.SuccessEscapeResponse;

public interface UserEscapeRegisterUseCase {

    SuccessEscapeResponse checkUserAnswer(String studentNo, int roomId, String userAnswer);
}

