package com.bulatmain.conference.domain.user.value.exception;

public class IllegalNameException extends RuntimeException {
    public IllegalNameException(String format) {
        super(format);
    }
}
