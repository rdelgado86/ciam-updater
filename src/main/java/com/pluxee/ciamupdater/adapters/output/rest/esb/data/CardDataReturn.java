package com.pluxee.ciamupdater.adapters.output.rest.esb.data;

import lombok.Data;

@Data
public class CardDataReturn {
  private long cardId;
  private String cardNumber;
  private int cardStatus;
}
