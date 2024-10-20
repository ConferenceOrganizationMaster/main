package com.bulatmain.conference.domain.user.value.exception;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String format) {
        super(format);
    }
}
