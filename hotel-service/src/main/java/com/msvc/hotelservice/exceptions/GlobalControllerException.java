package com.msvc.hotelservice.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerException {

  @SuppressWarnings("unchecked")
  @ExceptionHandler(ResourceNotFountException.class)
  public ResponseEntity<Map<String, Object>> handlerResourceNotFoundException(
      ResourceNotFountException resourceNotFountException) {

    @SuppressWarnings("rawtypes")
    Map map = new HashMap();
    map.put("message", resourceNotFountException.getMessage());
    map.put("success", false);
    map.put("Status: ", HttpStatus.NOT_FOUND);
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
  }
}
