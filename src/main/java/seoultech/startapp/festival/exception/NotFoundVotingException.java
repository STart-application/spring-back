package seoultech.startapp.festival.exception;

import seoultech.startapp.global.exception.BusinessException;
import seoultech.startapp.global.exception.ErrorType;

public class NotFoundVotingException extends BusinessException {
  public NotFoundVotingException(String message) {
    super(ErrorType.NOT_FOUND_RESOURCE, message);
  }

}
