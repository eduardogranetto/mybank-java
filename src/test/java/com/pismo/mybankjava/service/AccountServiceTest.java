package com.pismo.mybankjava.service;

import com.pismo.mybankjava.dto.AccountDTO;
import com.pismo.mybankjava.entity.Account;
import com.pismo.mybankjava.exception.NotFoundException;
import com.pismo.mybankjava.fixture.AccountFixture;
import com.pismo.mybankjava.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

  @Mock
  private AccountRepository accountRepository;

  @InjectMocks
  private AccountService accountService;

  @Captor
  private ArgumentCaptor<Account> accountCaptor;

  @Test
  public void shouldCreateAccountWithSuccess(){

    AccountDTO toCreateDTO = AccountFixture.fixtureDTO().build();
    AccountDTO createdDTO = accountService.create(toCreateDTO);

    verify(accountRepository, Mockito.times(1)).save(accountCaptor.capture());

    Account createdAccount = accountCaptor.getValue();

    assertThat(createdDTO).usingRecursiveComparison().isEqualTo(
      AccountFixture.fixtureDTO()
        .documentNumber(toCreateDTO.getDocumentNumber())
        .id(createdAccount.getId())
        .build()
    );

  }

  @Test
  public void shouldRetrieveAccountWithSuccess(){
    Account persistedAccount = AccountFixture.fixture().build();
    when(accountRepository.findById(persistedAccount.getId())).thenReturn(Optional.of(persistedAccount));

    AccountDTO persistedAccountDTO = accountService.get(persistedAccount.getId());

    assertThat(persistedAccountDTO).usingRecursiveComparison().isEqualTo(AccountFixture.fixtureDTO().build());
  }

  @Test
  public void shouldReturnNotFoundIfAccountDoesNotExist(){
    UUID notFoundId = UUID.fromString("05f1277c-5255-40f3-96bb-743be5012216");
    when(accountRepository.findById(notFoundId)).thenReturn(Optional.empty());

    NotFoundException e = assertThrows(NotFoundException.class, () -> accountService.get(notFoundId));

    assertThat(e.getCode()).isEqualTo("ACCOUNT_NOT_FOUND");
    assertThat(e.getMessage()).isEqualTo("Account id=05f1277c-5255-40f3-96bb-743be5012216 not found");
  }

}
