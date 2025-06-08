package com.noralearn.shippingtracker.service;

import com.noralearn.shippingtracker.dto.request.CreateCustomerDto;
import com.noralearn.shippingtracker.dto.response.CustomerDto;
import com.noralearn.shippingtracker.mapper.CreateCustomerMapper;
import com.noralearn.shippingtracker.mapper.CustomerMapper;
import com.noralearn.shippingtracker.model.Customer;
import com.noralearn.shippingtracker.repository.CustomerRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

  private final CustomerMapper customerMapper;
  private final CreateCustomerMapper createCustomerMapper;

  private final CustomerRepository customerRepository;

  @CacheEvict(value = "customers", allEntries = true)
  public Boolean bulkCreate(List<CreateCustomerDto> createCustomerDtos) {
    final List<Customer> customers = this.createCustomerMapper.createCustomerDtosToCustomers(createCustomerDtos);

    this.customerRepository.saveAll(customers);

    return true;
  }

  @Cacheable(value = "customers")
  public List<CustomerDto> getAll(){
    final List<Customer> customers = this.customerRepository.findAll();

    return this.customerMapper.customersToCustomerDtos(customers);
  }
}
