package com.noralearn.shippingtracker.repository;

import com.noralearn.shippingtracker.model.Customer;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, UUID> {

  List<Customer> findAll();
}
