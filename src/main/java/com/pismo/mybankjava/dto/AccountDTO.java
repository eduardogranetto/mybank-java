package com.pismo.mybankjava.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
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

  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

}
