package com.bulatmain.conference.application.usecase;


import com.bulatmain.conference.application.usecase.impl.exception.UnsuccessfulRegisterAttempt;
import com.bulatmain.conference.application.usecase.impl.exception.UseCaseException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UseCase {
    protected void throwAndLogFormatMessage(
            Class<? extends UseCaseException> exceptionClass,
            String formatMessage, Object... objects)
            throws UseCaseException {
        throwAndLogMessage(exceptionClass, String.format(
                formatMessage,
                objects)
        );
    }

    protected void throwAndLogMessage(Class<? extends UseCaseException> exceptionClass, String message)
            throws UseCaseException {
        UseCaseException exception;
        try {
            log.debug(message);
            exception = exceptionClass
                    .getDeclaredConstructor(String.class)
                    .newInstance(message);
        } catch (Exception thrown) {
            throw new RuntimeException(thrown);
        }
        throw exception;
    }
}
