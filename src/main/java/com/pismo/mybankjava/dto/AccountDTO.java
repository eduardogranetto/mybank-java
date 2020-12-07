package com.pismo.mybankjava.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.UUID;

@Builder
@AllArgsConstructor
@Data
public class AccountDTO {

  @JsonIgnore
  private UUID id;

  @NotBlank
  @JsonProperty("document_number")
  private String documentNumber;

  @JsonIgnore
  private BigDecimal availableCredit;

  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  @JsonProperty("available_credit")
  public BigDecimal getAvailableCredit() {
    return availableCredit;
  }
}
