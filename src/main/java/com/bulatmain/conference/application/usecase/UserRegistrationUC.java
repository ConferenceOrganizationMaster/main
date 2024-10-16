package com.bulatmain.conference.application.usecase;

import com.bulatmain.conference.application.model.UserRegistrationRequestData;
import com.bulatmain.conference.application.usecase.impl.exception.UnsuccessfulRegisterAttempt;

public interface UserRegistrationUC {
    void execute(UserRegistrationRequestData requestData) throws UnsuccessfulRegisterAttempt;
}
