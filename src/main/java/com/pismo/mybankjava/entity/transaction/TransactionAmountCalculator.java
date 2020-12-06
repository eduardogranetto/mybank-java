package com.pismo.mybankjava.entity.transaction;

import java.math.BigDecimal;

public interface TransactionAmountCalculator {

  BigDecimal calculate(BigDecimal amount);

}
