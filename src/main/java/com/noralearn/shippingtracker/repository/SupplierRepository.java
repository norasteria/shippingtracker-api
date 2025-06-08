package com.noralearn.shippingtracker.repository;

import com.noralearn.shippingtracker.model.Supplier;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface SupplierRepository extends CrudRepository<Supplier, UUID> {

  List<Supplier> findAll();
}
