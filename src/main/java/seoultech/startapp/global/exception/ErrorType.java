package seoultech.startapp.global.exception;

import lombok.Getter;


@Getter
public enum ErrorType {
  //공통 사항
  INVALID_INPUT("ST001", 400),
  INVALID_HEADER("ST002", 400),
  INVALID_JWT_FAIl("ST010", 401),
  EXPIRED_JWT_FAIL("ST011", 401),
  AUTHORIZATION_FAIL("ST030", 403),
  NOT_FOUND_PATH("ST040", 404),
  NOT_FOUND_RESOURCE("ST041", 404),

  //예외 처리 사항
  NOT_MATCH_PASSWORD("ST050", 409),
  NOT_LOGIN_MEMBER("ST051",409),
  NOT_MATCH_LOGIN_INFO("ST052", 409),
  DUPLICATE_STUDENT_NO("ST053",409),

  EXCEED_AVAILABLE_ITEM("ST054",409),
  DUPLICATE_ITEM_NO("ST055",409),
  NOT_RENTABLE_ITEM("ST056",409),
  REQUIRE_CARD_AUTH("ST057", 409),
  LEAVE_MEMBER("ST058", 409),
  ALREADY_CARD_AUTH("ST059", 409),
  ALREADY_STAMP("ST060",409),
  NOT_CONFIRM_RENT("SE061",409),
  INTERNAL_SERVER_ERROR("ST999",500);


  private final String errorType;
  private final int statusCode;

  ErrorType(String errorType, int statusCode) {
    this.errorType = errorType;
    this.statusCode = statusCode;
  }
}
