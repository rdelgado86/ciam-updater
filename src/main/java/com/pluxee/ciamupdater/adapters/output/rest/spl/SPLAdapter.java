package com.pluxee.ciamupdater.adapters.output.rest.spl;

import com.pluxee.ciamupdater.ports.output.SPLOutPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class SPLAdapter implements SPLOutPort {

  @Override
  public String getConsumerId(String cardId) {
    return null;
  }

  @Override
  public void updateCiamId(String consumerId, String ciamId) {

  }
}
