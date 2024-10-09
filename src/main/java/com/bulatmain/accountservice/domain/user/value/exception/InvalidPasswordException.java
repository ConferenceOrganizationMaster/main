package com.bulatmain.accountservice.domain.user.value.exception;

public class InvalidPasswordException extends Throwable {
    public InvalidPasswordException(String format) {
        super(format);
    }
}
