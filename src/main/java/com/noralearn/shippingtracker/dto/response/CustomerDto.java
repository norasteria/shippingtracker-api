package com.noralearn.shippingtracker.dto.response;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {

  private UUID id;

  private String companyName;

  private String city;

  private String address;

  private String province;

  private String slug;
}
