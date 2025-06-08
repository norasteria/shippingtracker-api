package com.noralearn.shippingtracker.dto.request;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerDto {

  @NotBlank
  private String companyName;

  @Nullable
  private String city;

  @Nullable
  private String address;

  @Nullable
  private String province;

  @Nullable
  private String slug;
}
