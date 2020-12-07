package com.pismo.mybankjava.exception;

public class LimitExceededException extends CodeException{

  public LimitExceededException(String code, String message) {
    super(code, message);
  }
}
