package com.bulatmain.accountservice.domain.user.value.exception;

public class IllegalNameException extends Throwable {
    public IllegalNameException(String format) {
        super(format);
    }
}
