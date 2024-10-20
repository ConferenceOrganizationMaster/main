package com.bulatmain.conference.application.usecase.impl.exception;

public class InvalidEmailException extends UnsuccessfulRegisterAttempt {
    public InvalidEmailException(String info) {
        super(info);
    }
}
