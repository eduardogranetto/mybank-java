package com.pismo.mybankjava.fixture;

import com.pismo.mybankjava.dto.TransactionDTO;
import com.pismo.mybankjava.entity.transaction.Transaction;

import java.math.BigDecimal;
import java.util.UUID;

import static com.pismo.mybankjava.entity.transaction.OperationType.BUY_CASH;

public final class TransactionFixture {

  public static TransactionDTO.TransactionDTOBuilder fixtureDTO(){
    return TransactionDTO.builder()
      .accountId(UUID.fromString("229781f6-59eb-48a4-bd73-963c776d1a63"))
      .amount(BigDecimal.TEN)
      .operationType(BUY_CASH);
  }


  public static Transaction.TransactionBuilder fixture(){
    return Transaction.builder()
      .id(UUID.fromString("f5f2247a-a0ad-42d1-894e-919ebd8e17ae"))
      .accountId(UUID.fromString("229781f6-59eb-48a4-bd73-963c776d1a63"))
      .amount(BigDecimal.TEN)
      .operationType(BUY_CASH)
      ;
  }

}
