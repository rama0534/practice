package org.producercomsumer.exception;

import lombok.Getter;

@Getter
public class MaxUploadSizeExceededException extends RuntimeException{
    private final long maxUploadSize;

    public MaxUploadSizeExceededException(long maxUploadSize) {
        super("Maximum upload size exceeded: " + maxUploadSize);
        this.maxUploadSize = maxUploadSize;
    }
}
