package com.rama.hellocontroller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandlerMethods {

    @ExceptionHandler(value = NullPointerException.class)
    public String handleNullPointException(Exception e) {

        System.out.println("Null Pointer Exception Occurred:" + e);
        return "NullPointerException";
    }

    @ExceptionHandler(value = IOException.class)
    public String handleIOException(Exception e) {

        System.out.println("IO Exception Occurred:" + e);
        return "IOException";
    }

    @ExceptionHandler(value = Exception.class)
    public String Exception(Exception e) {

        System.out.println("Unknown Exception Occurred:" + e);
        return "Exception";
    }

}
