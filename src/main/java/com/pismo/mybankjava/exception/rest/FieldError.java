package com.pismo.mybankjava.exception.rest;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FieldError {

  private final Error error;
  private final String field;

}
