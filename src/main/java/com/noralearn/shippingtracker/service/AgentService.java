package com.noralearn.shippingtracker.service;

import com.noralearn.shippingtracker.dto.response.AgentDto;
import com.noralearn.shippingtracker.mapper.AgentMapper;
import com.noralearn.shippingtracker.repsitory.AgentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgentService {

  private final AgentRepository agentRepository;

  private final AgentMapper agentMapper;

  public List<AgentDto> getAll() {
    return this.agentMapper.agentsToAgentsDto(this.agentRepository.findAll());
  }
}
