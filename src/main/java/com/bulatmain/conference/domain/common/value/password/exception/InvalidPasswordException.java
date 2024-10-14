package com.bulatmain.conference.domain.common.value.password.exception;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String format) {
        super(format);
    }
}
