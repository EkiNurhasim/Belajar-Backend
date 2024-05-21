package com.ekiasari.springboot.tutorial.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ekiasari.springboot.tutorial.entity.ErrorMessage;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityException extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = DepartmentNotFoundException.class)
  public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotFoundException department) {
    ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, department.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
  }
}
