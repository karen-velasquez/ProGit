package com.karen_velasquez.www.ProGit;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class MinibusNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(MinibusNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String employeeNotFoundHandler(MinibusNotFoundException ex) {
    return ex.getMessage();
  }
}