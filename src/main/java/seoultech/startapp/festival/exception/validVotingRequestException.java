package seoultech.startapp.festival.exception;

import seoultech.startapp.global.exception.BusinessException;
import seoultech.startapp.global.exception.ErrorType;

public class validVotingRequestException extends BusinessException {
  public validVotingRequestException(String message) {
    super(ErrorType.INVALID_INPUT, message);
  }
}
