package com.pismo.mybankjava.exception;


import lombok.Getter;

@Getter
public class CodeException extends RuntimeException{

  private final String code;

  public CodeException(String code, String message){
    super(message);
    this.code = code;
  }

}
