package com.noralearn.shippingtracker.exception;

import org.springframework.http.HttpStatus;

public class DataValidationException extends BaseException{

  public DataValidationException(String message){
    super(HttpStatus.BAD_REQUEST, "invalid-data", message);
  }
}
