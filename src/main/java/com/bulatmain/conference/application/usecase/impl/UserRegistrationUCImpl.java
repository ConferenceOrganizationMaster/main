package com.bulatmain.conference.application.usecase.impl;

import com.bulatmain.conference.application.model.UserRegistrationRequestData;
import com.bulatmain.conference.application.port.UserGateway;
import com.bulatmain.conference.application.usecase.UserRegistrationUC;
import com.bulatmain.conference.application.usecase.impl.exception.*;
import com.bulatmain.conference.domain.common.value.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class UserRegistrationUCImpl implements UserRegistrationUC {

    private final UserGateway userGateway;
    private final Validator<String> emailValidator;
    private final Validator<String> loginValidator;
    private final Validator<String> passwordValidator;

    @Override
    public void execute(UserRegistrationRequestData requestData) throws UnsuccessfulRegisterAttempt {
        checkNoUserWithSuchEmail(requestData.getEmail());
        checkFieldsValidity(requestData);
        userGateway.register(requestData.toDTO());
    }

    void checkNoUserWithSuchEmail(String email) throws UnsuccessfulRegisterAttempt {
        var userOpt = userGateway.findUserByEmail(email);
        if (userOpt.isPresent()) {
            throwAndLogFormatMessage(
                    UserAlreadyExistsException.class,
                    "Unsuccessful attempt to register: user with email %s already exist",
                    email
            );
        }
    }

    void checkFieldsValidity(UserRegistrationRequestData requestData) throws UnsuccessfulRegisterAttempt{
        var email = requestData.getEmail();
        var login = requestData.getLogin();
        var password = requestData.getPassword();
        if (!emailValidator.check(email)) {
            throwAndLogFormatMessage(
                    InvalidEmailException.class,
                    "Unsuccessful attempt to register: invalid email: %s",
                    email
            );
        }
        if (!loginValidator.check(login)) {
            throwAndLogFormatMessage(
                    InvalidLoginException.class,
                    "Unsuccessful attempt to register: invalid login: %s",
                    login
            );
        }
        if (!passwordValidator.check(password)) {
            throwAndLogFormatMessage(
                    InvalidPasswordException.class,
                    "Unsuccessful attempt to register: invalid password: %s",
                    password
            );
        }
    }

    void throwAndLogFormatMessage(
            Class<? extends UnsuccessfulRegisterAttempt> exceptionClass,
            String formatMessage, Object... objects)
            throws UnsuccessfulRegisterAttempt {
        throwAndLogMessage(exceptionClass, String.format(
                formatMessage,
                objects)
        );
    }

    void throwAndLogMessage(Class<? extends UnsuccessfulRegisterAttempt> exceptionClass, String message)
            throws UnsuccessfulRegisterAttempt {
        UnsuccessfulRegisterAttempt exception;
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
