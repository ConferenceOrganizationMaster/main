package com.bulatmain.accountservice.domain.user.value.exception;

public class IllegalEmailException extends Throwable {
    public IllegalEmailException(String format) {
        super(format);
    }
}
