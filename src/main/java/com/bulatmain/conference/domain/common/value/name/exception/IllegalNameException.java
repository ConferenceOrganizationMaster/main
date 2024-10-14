package com.bulatmain.conference.domain.common.value.name.exception;

public class IllegalNameException extends RuntimeException {
    public IllegalNameException(String format) {
        super(format);
    }
}
