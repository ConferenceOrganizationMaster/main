package com.bulatmain.conference.application.usecase.impl.exception;

public class NoSuchUserException extends UnsuccessfulRegisterAttempt {
    public NoSuchUserException(String info) {
        super(info);
    }
}
