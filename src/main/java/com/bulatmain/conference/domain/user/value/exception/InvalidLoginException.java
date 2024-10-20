package com.bulatmain.conference.domain.user.value.exception;

public class InvalidLoginException extends Throwable {
    public InvalidLoginException(String format) {
        super(format);
    }
}
