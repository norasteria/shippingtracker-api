package com.noralearn.shippingtracker.mapper;

import com.noralearn.shippingtracker.dto.response.AgentDto;
import com.noralearn.shippingtracker.model.Agent;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AgentMapper {

  List<AgentDto> agentsToAgentsDto(List<Agent> agents);
}
