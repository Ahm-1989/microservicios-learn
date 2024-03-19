package com.msvc.hotelservice.exceptions;

public class ResourceNotFountException extends RuntimeException {
  public ResourceNotFountException() {
    super("Recurso no encontrado en el servidor.");
  }

  public ResourceNotFountException(String error) {
    super(error);
  }
}
