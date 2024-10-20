package com.bulatmain.conference.application.usecase.impl.exception;

public class InvalidLoginException extends UnsuccessfulRegisterAttempt {
    public InvalidLoginException(String info) {
        super(info);
    }
}
