package com.pismo.mybankjava.entity.transaction;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Builder
public class Transaction {

  @Id
  private UUID id;

  @Column("account_id")
  private UUID accountId;


  @Column("operation_type")
  private OperationType operationType;

  private BigDecimal amount;

  @Column("event_date")
  private OffsetDateTime eventDate;

}
