package com.msvc.usuario.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException() {
        super("Resource not found on server");
    }

    public ResourceNotFoundException(String message) {
        super("Resource not found, check: " + message);
    }
}