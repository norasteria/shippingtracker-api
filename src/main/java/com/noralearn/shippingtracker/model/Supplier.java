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

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "suppliers")
public class Supplier extends BaseModel {

  @NotBlank
  @Column(nullable = false)
  private String name;

  @Nullable
  private String alias;
}
