package org.producercomsumer.exception;

public class FileNotFoundException extends RuntimeException {
    public FileNotFoundException(Long id) {
        super("File with id: " + id + " not found");
    }
}
