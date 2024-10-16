package com.bulatmain.conference.application.usecase.impl;

import com.bulatmain.conference.application.model.UserDTO;
import com.bulatmain.conference.application.model.UserRegistrationRequestData;
import com.bulatmain.conference.application.port.UserGateway;
import com.bulatmain.conference.application.usecase.UserRegistrationUC;
import com.bulatmain.conference.application.usecase.impl.exception.UnsuccessfulRegisterAttempt;
import com.bulatmain.conference.application.validator.KasperskyPasswordReqsValidator;
import com.bulatmain.conference.domain.common.value.email.EmailValidator;
import com.bulatmain.conference.domain.common.value.login.DefaultLoginValidator;
import com.bulatmain.conference.domain.common.value.validator.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

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
            throwAndLogMessage(String.format(
                    "Unsuccessful attempt to register: user with email %s already exist",
                    email
            ));
        }
    }

    void checkFieldsValidity(UserRegistrationRequestData requestData) throws UnsuccessfulRegisterAttempt{
        var email = requestData.getEmail();
        var login = requestData.getLogin();
        var password = requestData.getPassword();
        if (!emailValidator.check(email)) {
            throwAndLogMessage(String.format(
                    "Unsuccessful attempt to register: invalid email: %s",
                    email
            ));
        }
        if (!loginValidator.check(login)) {
            throwAndLogMessage(String.format(
                    "Unsuccessful attempt to register: invalid login: %s",
                    login
            ));
        }
        if (!passwordValidator.check(password)) {
            throwAndLogMessage(String.format(
                    "Unsuccessful attempt to register: invalid password: %s",
                    password
            ));
        }
    }

    void throwAndLogMessage(String message) throws UnsuccessfulRegisterAttempt {
        log.debug(message);
        throw new UnsuccessfulRegisterAttempt(message);
    }
}
