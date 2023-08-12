package com.pluxee.ciamupdater.adapters.output.rest.esb.data;

import java.util.ArrayList;
import lombok.Data;

@Data
public class EsbCheckCardStatusResponse {

  private String versaoChamada;
  private int code;
  private String message;
  private String document;
  private String initialDate;
  private String finalDate;
  private String dateTime;
  private String currelationId;
  private int searchType;
  private ArrayList<Object> accountDataReturnV3;
}
