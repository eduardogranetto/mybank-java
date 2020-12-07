package com.pismo.mybankjava.service;

import com.pismo.mybankjava.dto.AccountDTO;
import com.pismo.mybankjava.entity.Account;
import com.pismo.mybankjava.exception.LimitExceededException;
import com.pismo.mybankjava.exception.NotFoundException;
import com.pismo.mybankjava.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

import static com.pismo.mybankjava.converter.AccountConverter.toDTO;
import static java.math.BigDecimal.ZERO;

@Service
@AllArgsConstructor
public class AccountService {

  private final AccountRepository accountRepository;

  public AccountDTO create(AccountDTO accountDTO) {
    Account account = Account.builder()
      .documentNumber(accountDTO.getDocumentNumber())
      .availableCredit(ZERO)
      .build();
    accountRepository.save(account);
    return toDTO(account);
  }

  public AccountDTO get(UUID id) {
    return toDTO(accountRepository.findById(id).orElseThrow(() -> new NotFoundException("ACCOUNT_NOT_FOUND", "Account id=" + id + " not found")));
  }

  public void updateAvailableCredit(AccountDTO accountDTO, BigDecimal amount) {
    if(accountDTO.getAvailableCredit().add(amount).compareTo(ZERO) < 0){
      throw new LimitExceededException("LIMIT_EXCEED", "Account limit exceeded!");
    }
    accountRepository.updateAvailableCredit(accountDTO.getId(), amount);
  }
}
