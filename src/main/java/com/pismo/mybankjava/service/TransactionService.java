package com.pismo.mybankjava.service;

import com.pismo.mybankjava.dto.AccountDTO;
import com.pismo.mybankjava.dto.TransactionDTO;
import com.pismo.mybankjava.entity.transaction.Transaction;
import com.pismo.mybankjava.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import static com.pismo.mybankjava.converter.TransactionConverter.toDTO;

@AllArgsConstructor
@Service
public class TransactionService {

  private final AccountService accountService;
  private final TransactionRepository transactionRepository;

  public TransactionDTO create(TransactionDTO transactionDTO) {
    BigDecimal calculatedAmount = transactionDTO.getOperationType().calculate(transactionDTO.getAmount());
    AccountDTO accountDTO = accountService.get(transactionDTO.getAccountId());
    accountService.updateAvailableCredit(accountDTO, calculatedAmount);
    Transaction transaction = Transaction.builder()
      .accountId(accountDTO.getId())
      .operationType(transactionDTO.getOperationType())
      .amount(calculatedAmount)
      .eventDate(OffsetDateTime.now())
      .build();
    transactionRepository.save(transaction);
    return toDTO(transaction);
  }

}
