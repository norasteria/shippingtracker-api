package com.noralearn.shippingtracker.mapper;

import com.noralearn.shippingtracker.dto.request.CreateDestinationPortDto;
import com.noralearn.shippingtracker.dto.response.DestinationPortDto;
import com.noralearn.shippingtracker.model.DestinationPort;
import java.util.List;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = false))
public interface DestinationPortMapper {

  DestinationPortDto destinationToDestinationPortDto(DestinationPort destinationPort);

  DestinationPort createDestinationPortDtoToDestinationPort(CreateDestinationPortDto createDestinationPortDto);

  List<DestinationPortDto> destinationPortsToDestinationDtos(List<DestinationPort> destinationPorts);

  List<DestinationPort> createDestinationDtosToDestinationPorts(List<CreateDestinationPortDto> createDestinationPortDtos);
}
