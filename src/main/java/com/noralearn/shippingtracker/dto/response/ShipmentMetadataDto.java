package com.noralearn.shippingtracker.dto.response;


import java.util.List;
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
public class ShipmentMetadataDto {

  private List<CustomerDto> customers;

  private List<SupplierDto> suppliers;

  private List<DestinationPortDto> destinationPorts;

  private List<AgentDto> agents;
}
