package com.noralearn.shippingtracker.controller;

import com.noralearn.shippingtracker.dto.response.AgentDto;
import com.noralearn.shippingtracker.factory.ApiResponseFactory;
import com.noralearn.shippingtracker.service.AgentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agents")
public class AgentController {

  private final AgentService agentService;

  @GetMapping
  @ResponseStatus(value = HttpStatus.OK)
  public ApiResponseFactory<List<AgentDto>> getAll(){
    final List<AgentDto> agents = this.agentService.getAll();

    return ApiResponseFactory.success(agents);
  }
}
