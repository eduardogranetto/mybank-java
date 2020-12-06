package com.pismo.mybankjava.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pismo.mybankjava.entity.transaction.OperationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

@Data
@Builder
@AllArgsConstructor
public class TransactionDTO {

  @JsonIgnore
  private UUID id;

  @NotNull
  @JsonProperty("account_id")
  private UUID accountId;

  @NotNull
  @JsonProperty("operation_type")
  private OperationType operationType;

  @NotNull
  @Positive
  private BigDecimal amount;

  @JsonIgnore
  private OffsetDateTime eventDate;

  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  @JsonProperty("event_date")
  @JsonFormat(shape = STRING)
  public OffsetDateTime getEventDate() {
    return eventDate;
  }
}
