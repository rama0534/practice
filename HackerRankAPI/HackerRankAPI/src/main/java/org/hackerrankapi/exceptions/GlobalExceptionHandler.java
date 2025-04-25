package org.hackerrankapi.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidPageSizeException.class)
    public ResponseEntity<String> handleInvalidPageSize(InvalidPageSizeException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());

    }
}
