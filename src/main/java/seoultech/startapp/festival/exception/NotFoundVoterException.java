package seoultech.startapp.festival.exception;

import seoultech.startapp.global.exception.BusinessException;
import seoultech.startapp.global.exception.ErrorType;

public class NotFoundVoterException extends BusinessException {

  public NotFoundVoterException(String message) {
    super(ErrorType.NOT_FOUND_RESOURCE, message);
  }
}
