package com.mindhub.test.exceptions;

public class NotFoundTaskException extends RuntimeException {

    public NotFoundTaskException(String message) {
        super(message);
    }
}
