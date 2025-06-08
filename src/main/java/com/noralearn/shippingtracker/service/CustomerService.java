package com.noralearn.shippingtracker.service;

import com.noralearn.shippingtracker.dto.request.CreateCustomerDto;
import com.noralearn.shippingtracker.mapper.CustomerMapper;
import com.noralearn.shippingtracker.model.Customer;
import com.noralearn.shippingtracker.repository.CustomerRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

  private final CustomerMapper customerMapper;

  private final CustomerRepository customerRepository;

  public Boolean bulkCreate(List<CreateCustomerDto> createCustomerDtos) {
    final List<Customer> customers = this.customerMapper.createCustomerDtosToCustomers(createCustomerDtos);

    this.customerRepository.saveAll(customers);

    return true;
  }
}
