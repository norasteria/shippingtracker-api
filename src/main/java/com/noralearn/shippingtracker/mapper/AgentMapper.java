package com.noralearn.shippingtracker.mapper;

import com.noralearn.shippingtracker.dto.response.AgentDto;
import com.noralearn.shippingtracker.model.Agent;
import java.util.List;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = false))
public interface AgentMapper {

  AgentDto agentToAgentDto(Agent agent);

  List<AgentDto> agentsToAgentsDto(List<Agent> agents);
}
