package com.noralearn.shippingtracker.repsitory;

import com.noralearn.shippingtracker.model.Agent;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface AgentRepository extends CrudRepository<Agent, UUID> {

  List<Agent> findAll();
}
