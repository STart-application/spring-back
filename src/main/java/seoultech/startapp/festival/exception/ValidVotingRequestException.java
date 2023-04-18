package seoultech.startapp.festival.exception;

import seoultech.startapp.global.exception.BusinessException;
import seoultech.startapp.global.exception.ErrorType;

public class ValidVotingRequestException extends BusinessException {
  public ValidVotingRequestException(String message) {
    super(ErrorType.INVALID_INPUT, message);
  }
}
