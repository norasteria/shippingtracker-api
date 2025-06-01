package com.noralearn.shippingtracker.model;

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
@Table(name = "whitelisted_users")
public class WhitelistedUser extends BaseModel {

  @NotBlank
  @Column(unique = true)
  private String email;

  @NotBlank
  private String fullName;
}
