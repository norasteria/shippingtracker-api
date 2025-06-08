package com.noralearn.shippingtracker.mapper;

import com.noralearn.shippingtracker.dto.request.CreateCustomerDto;
import com.noralearn.shippingtracker.exception.DataValidationException;
import com.noralearn.shippingtracker.model.Customer;
import java.util.List;
import org.mapstruct.AfterMapping;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface CreateCustomerMapper {

  List<Customer> createCustomerDtosToCustomers(List<CreateCustomerDto> customerDtos);

  Customer createCustomerDtoToCustomer(CreateCustomerDto createCustomerDto);

  @AfterMapping
  default void generateSlug(CreateCustomerDto createCustomerDto, @MappingTarget Customer customer) {

    if (createCustomerDto.getCity() != null && !createCustomerDto.getCity().isBlank()){
      customer.setCity(createCustomerDto.getCity().toLowerCase());
    }

    if (createCustomerDto.getProvince() != null && !createCustomerDto.getProvince().isBlank()){
      customer.setProvince(createCustomerDto.getProvince().toLowerCase());
    }

    if (createCustomerDto.getSlug() == null || createCustomerDto.getSlug().isBlank()) {

      if (createCustomerDto.getCompanyName() == null || createCustomerDto.getCompanyName().isBlank()){
        throw new DataValidationException("Company is required.");
      }

      String customSlug = createCustomerDto.getCompanyName()
          .toLowerCase()
          .replaceAll("[^a-z0-9\\s]", "")
          .trim()
          .replaceAll("\\s+", "-");

      if (customSlug.isBlank()){
        throw new DataValidationException("Customer slug cannot be empty");
      }

      customer.setSlug(customSlug);
    } else {
      customer.setSlug(createCustomerDto.getSlug());
    }
  }
}
