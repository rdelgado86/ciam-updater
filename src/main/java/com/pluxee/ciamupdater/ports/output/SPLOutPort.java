package com.pluxee.ciamupdater.ports.output;

public interface SPLOutPort {

  String getConsumerId(String cardId);

  void updateCiamId(String consumerId, String ciamId);
}
