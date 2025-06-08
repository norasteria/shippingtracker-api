package com.noralearn.shippingtracker.service;

import com.noralearn.shippingtracker.dto.response.ShipmentMetadataDto;
import com.noralearn.shippingtracker.mapper.AgentMapper;
import com.noralearn.shippingtracker.mapper.CustomerMapper;
import com.noralearn.shippingtracker.mapper.DestinationPortMapper;
import com.noralearn.shippingtracker.mapper.SupplierMapper;
import com.noralearn.shippingtracker.model.Agent;
import com.noralearn.shippingtracker.model.Customer;
import com.noralearn.shippingtracker.model.DestinationPort;
import com.noralearn.shippingtracker.model.Supplier;
import com.noralearn.shippingtracker.repository.AgentRepository;
import com.noralearn.shippingtracker.repository.CustomerRepository;
import com.noralearn.shippingtracker.repository.DestinationPortRepository;
import com.noralearn.shippingtracker.repository.SupplierRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShipmentMetadataService {

  private final CustomerMapper customerMapper;
  private final DestinationPortMapper destinationPortMapper;
  private final SupplierMapper supplierMapper;
  private final AgentMapper agentMapper;

  private final CustomerRepository customerRepository;
  private final DestinationPortRepository destinationPortRepository;
  private final SupplierRepository supplierRepository;
  private final AgentRepository agentRepository;

  public ShipmentMetadataDto getAll(){
    final List<Customer> customers = this.customerRepository.findAll();
    final List<DestinationPort> destinationPorts = this.destinationPortRepository.findAll();
    final List<Supplier> suppliers = this.supplierRepository.findAll();
    final List<Agent> agents = this.agentRepository.findAll();

    return ShipmentMetadataDto.builder()
        .customers(this.customerMapper.customersToCustomerDtos(customers))
        .destinationPorts(this.destinationPortMapper.destinationPortsToDestinationDtos(destinationPorts))
        .suppliers(this.supplierMapper.suppliersToSupplierDtos(suppliers))
        .agents(this.agentMapper.agentsToAgentsDto(agents))
        .build();
  }
}
