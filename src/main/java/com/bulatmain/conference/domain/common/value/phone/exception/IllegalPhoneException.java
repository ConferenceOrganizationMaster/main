package com.bulatmain.conference.domain.common.value.phone.exception;

public class IllegalPhoneException extends RuntimeException {
    public IllegalPhoneException(String format) {
        super(format);
    }
}
