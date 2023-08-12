package com.pluxee.ciamupdater.domain.service;

import com.pluxee.ciamupdater.domain.model.Consumer;
import com.pluxee.ciamupdater.ports.input.CSVInputPort;
import com.pluxee.ciamupdater.ports.output.ArarasOutPort;
import com.pluxee.ciamupdater.ports.output.ESBOutPort;
import com.pluxee.ciamupdater.ports.output.SPLOutPort;
import com.pluxee.ciamupdater.utils.CSVUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@AllArgsConstructor
public class CSVService implements CSVInputPort {

  private final ESBOutPort esbOutPort;
  private final SPLOutPort splOutPort;
  private final ArarasOutPort ararasOutPort;
  private final FilesStorageService filesStorageService;

  public void process(MultipartFile file) {
    try {
      var consumers = CSVUtil.csvToConsumers(file.getInputStream());

      for (Consumer consumer : consumers) {

        var cpf = consumer.getCpf();

        log.info("Coletando CARD ID do CPF {}", cpf);
        var cardId = esbOutPort.getCardId(cpf);

        log.info("Coletando CONSUMER ID com CARD ID {}", cardId);
        var consumerId = splOutPort.getConsumerId(cardId);

        log.info("Coletando CIAM ID com CARD ID {}", cardId);
        var ciamId = ararasOutPort.getCiamId(cardId);

        // atualizar o ciamId
        log.info("ATUALIZANDO CIAM ID {} com CONSUMER ID {}", ciamId, consumerId);
        splOutPort.updateCiamId(consumerId, ciamId);
      }

      //
      log.info("");
      filesStorageService.save(file);

    } catch (IOException e) {
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
  }
}
