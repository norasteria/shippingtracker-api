package com.noralearn.shippingtracker.controller;

import com.noralearn.shippingtracker.dto.request.BulkCreateCustomerDto;
import com.noralearn.shippingtracker.dto.request.BulkCreateDestinationPortDto;
import com.noralearn.shippingtracker.dto.request.BulkCreateSupplierDto;
import com.noralearn.shippingtracker.dto.response.ShipmentMetadataDto;
import com.noralearn.shippingtracker.factory.ApiResponseFactory;
import com.noralearn.shippingtracker.service.CustomerService;
import com.noralearn.shippingtracker.service.DestinationPortService;
import com.noralearn.shippingtracker.service.ShipmentMetadataService;
import com.noralearn.shippingtracker.service.SupplierService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shipment-metadata")
public class ShipmentMetadataController {

  private final ShipmentMetadataService shipmentMetadataService;
  private final CustomerService customerService;
  private final DestinationPortService destinationPortService;
  private final SupplierService supplierService;

  @GetMapping
  @ResponseStatus(value = HttpStatus.OK)
  public ApiResponseFactory<ShipmentMetadataDto> getAll() {
    final ShipmentMetadataDto shipmentMetadataDto = this.shipmentMetadataService.getAll();

    return ApiResponseFactory.success(shipmentMetadataDto);
  };

  @PostMapping("/bulk/customers")
  @ResponseStatus(value = HttpStatus.OK)
  public ApiResponseFactory<Boolean> bulkCreateCustomers(
      @Valid @RequestBody BulkCreateCustomerDto bulkRequest
  ) {
    return ApiResponseFactory.success(this.customerService.bulkCreate(bulkRequest.getData()));
  };

  @PostMapping("/bulk/destination-ports")
  @ResponseStatus(value = HttpStatus.OK)
  public ApiResponseFactory<Boolean> bulkCreateDestinationPorts(
      @Valid @RequestBody BulkCreateDestinationPortDto bulkRequest
  ) {
    return ApiResponseFactory.success(this.destinationPortService.bulkCreate(bulkRequest.getData()));
  }

  @PostMapping("/bulk/suppliers")
  @ResponseStatus(value = HttpStatus.OK)
  public ApiResponseFactory<Boolean> bulkCreateSuppliers(
      @Valid @RequestBody BulkCreateSupplierDto bulkRequest
  ) {
    return ApiResponseFactory.success(this.supplierService.bulkCreate(bulkRequest.getData()));
  }
}
