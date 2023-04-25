package seoultech.startapp.festival.exception;

import seoultech.startapp.global.exception.BusinessException;
import seoultech.startapp.global.exception.ErrorType;

public class NotVotedException extends BusinessException {
  public NotVotedException(String message) {
    super(ErrorType.NOT_VOTED, message);
  }

}
