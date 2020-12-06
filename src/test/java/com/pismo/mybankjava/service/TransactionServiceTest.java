package com.pismo.mybankjava.service;

import com.pismo.mybankjava.dto.TransactionDTO;
import com.pismo.mybankjava.entity.transaction.OperationType;
import com.pismo.mybankjava.entity.transaction.Transaction;
import com.pismo.mybankjava.fixture.AccountFixture;
import com.pismo.mybankjava.fixture.TransactionFixture;
import com.pismo.mybankjava.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

  @Mock
  private TransactionRepository transactionRepository;

  @Mock
  private AccountService accountService;

  @InjectMocks
  private TransactionService transactionService;

  @Captor
  private ArgumentCaptor<Transaction> transactionCaptor;

  @ParameterizedTest
  @CsvFileSource(resources = "/csv/transactions.csv")
  public void shouldCreateATransactionWithSuccess(OperationType operationType, BigDecimal amount, BigDecimal expectedAmount) {
    TransactionDTO toCreateDTO = TransactionFixture.fixtureDTO()
      .operationType(operationType)
      .amount(amount)
      .build();

    when(accountService.get(toCreateDTO.getAccountId())).thenReturn(AccountFixture.fixtureDTO().build());

    TransactionDTO createdDTO = transactionService.create(toCreateDTO);

    verify(transactionRepository, times(1)).save(transactionCaptor.capture());

    Transaction transactionCreated = transactionCaptor.getValue();

    assertThat(createdDTO).usingRecursiveComparison().isEqualTo(
      TransactionFixture.fixtureDTO()
        .amount(expectedAmount)
        .operationType(operationType)
        .id(transactionCreated.getId())
        .eventDate(transactionCreated.getEventDate())
        .build()
    );
  }

}
