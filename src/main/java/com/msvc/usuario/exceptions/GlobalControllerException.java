package com.msvc.usuario.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.msvc.usuario.response.ApiResponse;

@RestControllerAdvice
public class GlobalControllerException {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ApiResponse> handlerResourceNotFoundException(
    ResourceNotFoundException resourceNotFoundException) {
      String message = resourceNotFoundException.getMessage();
      new ApiResponse();
      ApiResponse response = ApiResponse
        .builder()
          .message(message)
          .success(true)
          .statusCode(HttpStatus.NOT_FOUND)
          .build();
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }
}
