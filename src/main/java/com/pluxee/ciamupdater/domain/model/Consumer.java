package com.pluxee.ciamupdater.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Consumer {

    private String consumerId;
    private String cpf;
    private String cardId;
    private String ciamId;

}
