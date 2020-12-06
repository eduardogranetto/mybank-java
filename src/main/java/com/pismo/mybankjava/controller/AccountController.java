package com.pismo.mybankjava.controller;

import com.pismo.mybankjava.dto.AccountDTO;
import com.pismo.mybankjava.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.ok;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/accounts")
public class AccountController {

  private final AccountService accountService;

  @PostMapping
  public ResponseEntity<?> create(@Valid @RequestBody AccountDTO accountDTO) {
    return ok(accountService.create(accountDTO));
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> get(@PathVariable UUID id){
    return ok(accountService.get(id));
  }

}
