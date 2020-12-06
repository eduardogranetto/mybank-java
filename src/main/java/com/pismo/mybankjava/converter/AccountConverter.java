package com.pismo.mybankjava.converter;

import com.pismo.mybankjava.dto.AccountDTO;
import com.pismo.mybankjava.entity.Account;

public class AccountConverter {

    public static AccountDTO toDTO(Account account){
      return AccountDTO.builder()
        .id(account.getId())
        .documentNumber(account.getDocumentNumber())
        .build();
    }


}
