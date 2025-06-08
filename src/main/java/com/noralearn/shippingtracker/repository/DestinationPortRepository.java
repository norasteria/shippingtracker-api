package com.noralearn.shippingtracker.repository;

import com.noralearn.shippingtracker.model.DestinationPort;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface DestinationPortRepository extends CrudRepository<DestinationPort, UUID> {

  List<DestinationPort> findAll();
}
