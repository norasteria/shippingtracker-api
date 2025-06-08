package com.noralearn.shippingtracker.service;

import com.noralearn.shippingtracker.dto.request.CreateDestinationPortDto;
import com.noralearn.shippingtracker.dto.response.DestinationPortDto;
import com.noralearn.shippingtracker.mapper.DestinationPortMapper;
import com.noralearn.shippingtracker.model.DestinationPort;
import com.noralearn.shippingtracker.repository.DestinationPortRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DestinationPortService {

  private final DestinationPortMapper destinationPortMapper;

  private final DestinationPortRepository destinationPortRepository;

  @CacheEvict(value = "destination_ports", allEntries = true)
  public boolean bulkCreate(List<CreateDestinationPortDto> createDestinationPortDtos){
    final List<DestinationPort> destinationPorts = this.destinationPortMapper.createDestinationDtosToDestinationPorts(createDestinationPortDtos);

    this.destinationPortRepository.saveAll(destinationPorts);

    return true;
  }

  @Cacheable(value = "destination_ports")
  public List<DestinationPortDto> getAll(){
    final List<DestinationPort> destinationPorts = this.destinationPortRepository.findAll();

    return this.destinationPortMapper.destinationPortsToDestinationDtos(destinationPorts);
  }
}
