package com.bulatmain.conference.application.usecase.impl.exception;

public class UnsuccessfulRegisterAttempt extends Exception {
    public UnsuccessfulRegisterAttempt(String info) {
        super(info);
    }
}
