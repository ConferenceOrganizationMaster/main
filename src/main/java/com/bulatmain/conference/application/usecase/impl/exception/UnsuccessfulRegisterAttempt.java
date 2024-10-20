package com.bulatmain.conference.application.usecase.impl.exception;

public class UnsuccessfulRegisterAttempt extends UseCaseException {
    public UnsuccessfulRegisterAttempt(String info) {
        super(info);
    }
}
