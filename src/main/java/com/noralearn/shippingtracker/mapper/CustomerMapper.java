package com.noralearn.shippingtracker.mapper;

import com.noralearn.shippingtracker.dto.request.CreateCustomerDto;
import com.noralearn.shippingtracker.dto.response.CustomerDto;
import com.noralearn.shippingtracker.model.Customer;
import java.util.List;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface CustomerMapper {

  List<CustomerDto> customersToCustomerDtos(List<Customer> customers);

  Customer createCustomerDtoToCustomer(CreateCustomerDto createCustomerDto);

  List<Customer> createCustomerDtosToCustomers(List<CreateCustomerDto> customerDtos);

  @AfterMapping
  default void generateSlug(CreateCustomerDto createCustomerDto, @MappingTarget Customer customer) {

    if (createCustomerDto.getCity() != null && !createCustomerDto.getCity().isBlank()){
      customer.setCity(createCustomerDto.getCity().toLowerCase());
    }

    if (createCustomerDto.getProvince() != null && !createCustomerDto.getProvince().isBlank()){
      customer.setProvince(createCustomerDto.getProvince().toLowerCase());
    }

    if (createCustomerDto.getSlug() == null || createCustomerDto.getSlug().isBlank()) {
      String customSlug = createCustomerDto.getCompanyName()
          .toLowerCase()
          .replaceAll("[^a-z0-9\\s]", "")
          .trim()
          .replaceAll("\\s+", "-");

      customer.setSlug(customSlug);
    } else {
      customer.setSlug(createCustomerDto.getSlug());
    }
  }
}
