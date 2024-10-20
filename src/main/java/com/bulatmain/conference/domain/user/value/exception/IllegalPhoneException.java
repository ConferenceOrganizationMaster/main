package com.bulatmain.conference.domain.user.value.exception;

public class IllegalPhoneException extends RuntimeException {
    public IllegalPhoneException(String format) {
        super(format);
    }
}
