package com.bulatmain.conference.application.usecase.impl.exception;

public class ConferenceAlreadyExistsException extends UnsuccessfulRegisterAttempt {
    public ConferenceAlreadyExistsException(String info) {
        super(info);
    }
}
