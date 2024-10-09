package com.bulatmain.accountservice.domain.user.value.exception;

public class InvalidLoginException extends Throwable {
    public InvalidLoginException(String format) {
        super(format);
    }
}
