package com.noralearn.shippingtracker.exception;

import java.io.Serial;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
* Base exception class for application-specific exceptions.
*/
@Getter
public class BaseException extends RuntimeException {
  @Serial
  private static final long serialVersionUID = 1L;

  private final HttpStatus httpStatus;

  private final String code;

  public BaseException(HttpStatus status, String code, String message){
    super(message);
    this.httpStatus = status;
    this.code = code;
  }
}
