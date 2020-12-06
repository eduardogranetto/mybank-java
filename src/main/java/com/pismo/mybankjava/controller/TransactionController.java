package com.pismo.mybankjava.controller;

import com.pismo.mybankjava.dto.TransactionDTO;
import com.pismo.mybankjava.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/transactions")
@AllArgsConstructor
public class TransactionController {

  private final TransactionService transactionService;

  @PostMapping
  public ResponseEntity<?> create(@Valid @RequestBody TransactionDTO transactionDTO){
    return ResponseEntity.ok(transactionService.create(transactionDTO));
  }

}
