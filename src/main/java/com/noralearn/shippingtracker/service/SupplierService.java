package com.noralearn.shippingtracker.service;

import com.noralearn.shippingtracker.dto.request.CreateSupplierDto;
import com.noralearn.shippingtracker.dto.response.SupplierDto;
import com.noralearn.shippingtracker.mapper.SupplierMapper;
import com.noralearn.shippingtracker.model.Supplier;
import com.noralearn.shippingtracker.repository.SupplierRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupplierService {

  private final SupplierMapper supplierMapper;

  private final SupplierRepository supplierRepository;

  @CacheEvict(value = "suppliers", allEntries = true)
  public Boolean bulkCreate(List<CreateSupplierDto> createSupplierDtos){
    final List<Supplier> suppliers = this.supplierMapper.createSupplierDtosToSuppliers(createSupplierDtos);

    this.supplierRepository.saveAll(suppliers);

    return true;
  }

  @Cacheable(value = "suppliers")
  public List<SupplierDto> getAll(){
    final List<Supplier> suppliers = this.supplierRepository.findAll();

    return this.supplierMapper.suppliersToSupplierDtos(suppliers);
  }
}
