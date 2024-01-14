package com.megazone.goop.racingcar.exception;

public class NotAllowedNumberException extends RuntimeException {

    public NotAllowedNumberException() {
    }

    public NotAllowedNumberException(String message) {
        super(message);
    }

    public NotAllowedNumberException(Throwable cause) {
        super(cause);
    }
}
