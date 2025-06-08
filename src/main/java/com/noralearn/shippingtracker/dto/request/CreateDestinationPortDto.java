package com.noralearn.shippingtracker.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateDestinationPortDto {

  @NotBlank
  private String incotermCode;

  @NotBlank
  private String name;
}
