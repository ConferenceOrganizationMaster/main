package com.bulatmain.conference.application.usecase.impl.exception;

public class UserAlreadyExistsException extends UnsuccessfulRegisterAttempt {
    public UserAlreadyExistsException(String info) {
        super(info);
    }
}
