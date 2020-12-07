package com.pismo.mybankjava.fixture;

import com.pismo.mybankjava.dto.AccountDTO;
import com.pismo.mybankjava.entity.Account;

import static java.math.BigDecimal.ZERO;
import static java.util.UUID.fromString;

public final class AccountFixture {

  public static AccountDTO.AccountDTOBuilder fixtureDTO() {
    return AccountDTO.builder()
      .id(fromString("229781f6-59eb-48a4-bd73-963c776d1a63"))
      .availableCredit(ZERO)
      .documentNumber("123456569");
  }

  public static Account.AccountBuilder fixture() {
    return Account.builder()
      .id(fromString("229781f6-59eb-48a4-bd73-963c776d1a63"))
      .availableCredit(ZERO)
      .documentNumber("123456569");
  }

}
