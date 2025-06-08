package com.noralearn.shippingtracker.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BulkCreateShipmentMetadata<MetaDataEntity> {

  @NotEmpty
  @Size(max = 1000)
  @Valid
  private List<MetaDataEntity> data;
}
