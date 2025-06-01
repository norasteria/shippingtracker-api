package com.noralearn.shippingtracker.factory;

import com.noralearn.shippingtracker.enums.ResponseStatusEnum;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponseFactory<ResponseData> {
  private ResponseStatusEnum status;
  private ResponseData data;
  private ErrorDetail error;

  public ApiResponseFactory(ResponseStatusEnum status, ResponseData data, ErrorDetail error) {
    this.status = status;
    this.data = data;
    this.error = error;
  }

  public static <ResponseData> ApiResponseFactory<ResponseData> success(ResponseData data) {
    return new ApiResponseFactory<>(ResponseStatusEnum.SUCCESS, data, null);
  }

  public static ApiResponseFactory<?> error(String code, String message){
    final ErrorDetail errorDetail = new ErrorDetail(code, message, Instant.now());
    return new ApiResponseFactory<>(ResponseStatusEnum.ERROR, null, errorDetail);
  }

  public record ErrorDetail(
      String code,
      String message,
      Instant timestamp
  ){}
}
