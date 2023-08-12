package com.pluxee.ciamupdater.adapters.output.rest.esb.data;

import lombok.Data;

@Data
public class EsbCheckCardStatusRequest {

  private String document;
  private String cardId;
  private String initialDate;
  private String finalDate;
}
