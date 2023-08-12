package com.pluxee.ciamupdater.adapters.output.rest.esb.data;

import java.util.ArrayList;
import lombok.Data;

@Data
public class AccountDataReturnV3 {
  private ArrayList<CardDataReturn> cardDataReturns;
}
