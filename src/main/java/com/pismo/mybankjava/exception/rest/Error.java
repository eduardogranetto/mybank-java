package com.pismo.mybankjava.exception.rest;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Error {

  private final String code;
  private final String message;

}
