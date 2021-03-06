package com.pismo.mybankjava.entity.transaction;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public class DebitAmountCalculator implements  TransactionAmountCalculator {

  @Override
  public BigDecimal calculate(BigDecimal amount) {
    return amount.negate();
  }

}
