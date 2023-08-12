package com.pluxee.ciamupdater.adapters.output.rest.esb;

import com.pluxee.ciamupdater.adapters.output.rest.esb.client.ESBApiClient;
import com.pluxee.ciamupdater.adapters.output.rest.esb.data.EsbCheckCardStatusRequest;
import com.pluxee.ciamupdater.ports.output.ESBOutPort;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RegExUtils;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class ESBAdapter implements ESBOutPort {

  private final ESBApiClient esbApiClient;

  @Override
  public String getCardId(String cpf) {
    // criar o header
    Map<String, String> header = new HashMap<>();
    header.put("systemname", "POSTMAN");
    header.put("consumerid", "consumerSearchBalanceMobile");
    header.put("contextid", "SerachBalanceService");
    header.put("vesrion", "3.0");
    header.put("addressip", "392.168.0.01");
    header.put("icllocale", "pt_BR");
    header.put("correlationid", "");
    header.put("Content-Type", "application/json");

    // criar Request
    EsbCheckCardStatusRequest esbCheckCardStatusRequest = new EsbCheckCardStatusRequest();
    esbCheckCardStatusRequest.setDocument(RegExUtils.removeAll(cpf, "[^\\d]"));
    esbCheckCardStatusRequest.setInitialDate(LocalDate.now().minusMonths(3).toString().replaceAll("-", ""));
    esbCheckCardStatusRequest.setFinalDate(LocalDate.now().toString().replaceAll("-", ""));

    var esbCheckCardStatusResponse = esbApiClient.checkCardStatus(header, esbCheckCardStatusRequest);

    // tratar resposta
    return null;
  }
}
