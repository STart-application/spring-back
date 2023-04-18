package seoultech.startapp.event.application.port.in;

import seoultech.startapp.event.application.SuccessEscapeResponse;

public interface UserEscapeRegisterUseCase {

    SuccessEscapeResponse checkUserAnswer(Long memberId, int roomId, String userAnswer);
}

