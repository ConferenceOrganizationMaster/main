package com.bulatmain.conference.domain.user.value.detail.exception;

public class IllegalNameException extends RuntimeException {
    public IllegalNameException(String format) {
        super(format);
    }
}
