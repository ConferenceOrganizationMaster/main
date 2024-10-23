package com.bulatmain.conference.domain.user.value.exception;

public class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String format) {
        super(format);
    }
}
