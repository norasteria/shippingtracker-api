package com.noralearn.shippingtracker.service;

import com.noralearn.shippingtracker.dto.response.ShipmentMetadataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShipmentMetadataService {

  private final CustomerService customerService;
  private final DestinationPortService destinationPortService;
  private final SupplierService supplierService;
  private final AgentService agentService;

  public ShipmentMetadataDto getAll(){

    return ShipmentMetadataDto.builder()
        .customers(this.customerService.getAll())
        .destinationPorts(this.destinationPortService.getAll())
        .suppliers(this.supplierService.getAll())
        .agents(this.agentService.getAll())
        .build();
  }
}
