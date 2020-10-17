package com.cuccatti.example.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cuccatti.example.exception.exceptions.UserNotFoundException;
import com.cuccatti.example.exception.model.ErrorHandlerResponse;

@ControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(UserNotFoundException.class)
  @ResponseBody
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorHandlerResponse userNotFoundExceptionHandler(UserNotFoundException ex) {
    ErrorHandlerResponse errorHandlingResponse = new ErrorHandlerResponse();
    errorHandlingResponse.setErrorMessage(ex.getMessage());
    errorHandlingResponse.setError(true);
    return errorHandlingResponse;
  }
}