package com.noralearn.shippingtracker.dto.request;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BulkCreateShipmentMetadata<MetaDataEntity> {

  @NotEmpty
  private List<MetaDataEntity> data;
}
