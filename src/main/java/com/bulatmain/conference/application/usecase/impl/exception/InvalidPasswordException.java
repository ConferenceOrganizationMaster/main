package com.bulatmain.conference.application.usecase.impl.exception;

public class InvalidPasswordException extends UnsuccessfulRegisterAttempt {
    public InvalidPasswordException(String info) {
        super(info);
    }
}
