package com.noralearn.shippingtracker.mapper;

import com.noralearn.shippingtracker.dto.response.CustomerDto;
import com.noralearn.shippingtracker.model.Customer;
import java.util.List;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = false))
public interface CustomerMapper {

  CustomerDto customerToCustomerDto(Customer customer);

  List<CustomerDto> customersToCustomerDtos(List<Customer> customers);
}
