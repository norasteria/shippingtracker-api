package com.noralearn.shippingtracker.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "shipments")
public class Shipment extends BaseModel {

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "customer_id")
  private Customer customer;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "agent_id")
  private Agent agent;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "incoterm_id")
  private Incoterm incoterm;

  @Nullable
  private String documentIndicator;

  @NotBlank
  private String destinationPort;
}
