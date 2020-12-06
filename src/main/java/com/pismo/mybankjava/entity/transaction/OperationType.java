package com.pismo.mybankjava.entity.transaction;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public enum OperationType implements TransactionAmountCalculator {
  BUY_CASH(DebitAmountCalculator.builder().build()),
  BUY_FINANCING(DebitAmountCalculator.builder().build()),
  PAYMENT(CreditAmountCalculator.builder().build()),
  WITHDRAW(DebitAmountCalculator.builder().build());

  private final TransactionAmountCalculator calculator;

  public BigDecimal calculate(BigDecimal amount) {
    return calculator.calculate(amount);
  }

}
