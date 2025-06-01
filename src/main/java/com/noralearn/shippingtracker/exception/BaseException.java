package com.noralearn.shippingtracker.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BaseException extends RuntimeException {
  private final HttpStatus httpStatus;

  private final String code;

  public BaseException(HttpStatus status, String code, String message){
    super(message);
    this.httpStatus = status;
    this.code = code;
  }
}
