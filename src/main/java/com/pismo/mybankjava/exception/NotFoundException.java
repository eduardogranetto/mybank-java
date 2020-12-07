package com.pismo.mybankjava.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends CodeException {

  public NotFoundException(String code, String message){
    super(code, message);
  }

}
