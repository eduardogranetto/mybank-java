package com.pismo.mybankjava.exception;

import com.pismo.mybankjava.exception.rest.Error;
import com.pismo.mybankjava.exception.rest.FieldError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public Error notFound(NotFoundException e) {
    return Error.builder()
      .code(e.getCode())
      .message(e.getMessage())
      .build();
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public List<FieldError> validationExceptions(MethodArgumentNotValidException e) {
    return e.getBindingResult()
      .getAllErrors()
      .stream()
      .map(error -> FieldError.builder()
        .field(e.getFieldError().getField())
        .error(
          Error.builder()
            .message(error.getDefaultMessage())
            .code(error.getCode())
            .build()
        ).build())
      .collect(toList());
  }

}
