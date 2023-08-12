package com.pluxee.ciamupdater.adapters.output.rest.esb.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.pluxee.ciamupdater.adapters.output.rest.esb.data.*;
import java.util.Map;

@FeignClient(name = "esb-service", url = "${esb-service-url}")
public interface ESBApiClient {

  @PutMapping("/checkCardStatus")
  EsbCheckCardStatusResponse checkCardStatus(
      @RequestHeader Map<String, String> headerMap,
      @RequestBody EsbCheckCardStatusRequest esbCheckCardStatusRequest);

}
