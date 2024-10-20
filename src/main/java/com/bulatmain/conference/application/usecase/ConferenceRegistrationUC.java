package com.bulatmain.conference.application.usecase;

import com.bulatmain.conference.application.model.ConferenceRegistrationRequestData;
import com.bulatmain.conference.application.usecase.impl.exception.UseCaseException;

public interface ConferenceRegistrationUC {
    void execute(ConferenceRegistrationRequestData requestData) throws UseCaseException;
}
