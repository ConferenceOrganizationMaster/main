package com.bulatmain.conference.domain.common.value.email.exception;

public class IllegalEmailException extends Throwable {
    public IllegalEmailException(String format) {
        super(format);
    }
}
