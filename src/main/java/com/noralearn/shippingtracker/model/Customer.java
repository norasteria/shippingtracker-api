package com.noralearn.shippingtracker.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "customers")
public class Customer extends BaseModel{

  @NotBlank
  @Column(nullable = false)
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
