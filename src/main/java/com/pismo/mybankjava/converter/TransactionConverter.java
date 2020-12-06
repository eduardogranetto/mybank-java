package com.pismo.mybankjava.converter;

import com.pismo.mybankjava.dto.TransactionDTO;
import com.pismo.mybankjava.entity.transaction.Transaction;

public class TransactionConverter {

    public static TransactionDTO toDTO(Transaction transaction){
      return TransactionDTO.builder()
        .id(transaction.getId())
        .accountId(transaction.getAccountId())
        .operationType(transaction.getOperationType())
        .amount(transaction.getAmount())
        .eventDate(transaction.getEventDate())
        .build();
    }

}
