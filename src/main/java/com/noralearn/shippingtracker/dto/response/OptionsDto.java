package com.noralearn.shippingtracker.dto.response;


import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OptionsDto {

  private Set<CustomerDto> customers;

  private Set<SupplierDto> suppliers;

  private Set<DestinationPortDto> destinationPorts;

  private Set<AgentDto> agents;
}
