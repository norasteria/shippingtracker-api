package com.noralearn.shippingtracker.exception;

import com.noralearn.shippingtracker.factory.ApiResponseFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class GlobalException {

  @ExceptionHandler(BaseException.class)
  public ResponseEntity<ApiResponseFactory<?>> handelCustomException(BaseException exception){
    log.error(exception.getMessage(), exception);

    return ResponseEntity
        .status(exception.getHttpStatus())
        .body(ApiResponseFactory.error(exception.getCode(), exception.getMessage()));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiResponseFactory<?>> handleGenericException(Exception exception) {
    log.error(exception.getMessage(), exception);

    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(ApiResponseFactory.error("general-error", exception.getMessage()));
  }
}
