package com.noralearn.shippingtracker.controller;

import com.noralearn.shippingtracker.dto.response.OptionsDto;
import com.noralearn.shippingtracker.factory.ApiResponseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/options")
public class OptionsController {

  @GetMapping
  @ResponseStatus(value = HttpStatus.OK)
  public ApiResponseFactory<OptionsDto> getOptions() {
    return null;
  };
}
