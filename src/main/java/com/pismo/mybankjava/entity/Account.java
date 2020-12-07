package com.pismo.mybankjava.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class Account {

  @Id
  private UUID id;

  @Column("document_number")
  private String documentNumber;

  @Column("available_credit")
  private BigDecimal availableCredit;

}
