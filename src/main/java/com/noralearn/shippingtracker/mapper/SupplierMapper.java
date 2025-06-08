package com.noralearn.shippingtracker.mapper;

import com.noralearn.shippingtracker.dto.request.CreateSupplierDto;
import com.noralearn.shippingtracker.dto.response.SupplierDto;
import com.noralearn.shippingtracker.model.Supplier;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

  List<SupplierDto> suppliersToSupplierDtos(List<Supplier> supplier);

  List<Supplier> createSupplierDtosToSuppliers(List<CreateSupplierDto> createSupplierDtos);
}
