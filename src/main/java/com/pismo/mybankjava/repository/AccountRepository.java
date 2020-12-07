package com.pismo.mybankjava.repository;

import com.pismo.mybankjava.entity.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.UUID;

@Repository
public interface AccountRepository extends CrudRepository<Account, UUID>{

  @Modifying
  @Query("update account set available_credit = available_credit + :amount where id = :id")
  void updateAvailableCredit(UUID id, BigDecimal amount);

}
