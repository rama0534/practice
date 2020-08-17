package org.messenger.exception;

public class DataNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 4489789407868104165L;

    public DataNotFoundException(String message) {
        super(message);
    }
}
