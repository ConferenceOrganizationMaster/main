package com.bulatmain.accountservice.domain.user.value.exception;

public class IllegalPhoneException extends Throwable {
    public IllegalPhoneException(String format) {
        super(format);
    }
}
