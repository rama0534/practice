package org.hackerrankapi.exceptions;

public class InvalidPageSizeException extends RuntimeException{
    public InvalidPageSizeException(String message) {
        super(message);
    }
}
