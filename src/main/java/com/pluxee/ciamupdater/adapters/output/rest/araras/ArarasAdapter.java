package com.pluxee.ciamupdater.adapters.output.rest.araras;

import com.pluxee.ciamupdater.ports.output.ArarasOutPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class ArarasAdapter implements ArarasOutPort {

  @Override
  public String getCiamId(String cardId) {
    return null;
  }
}
