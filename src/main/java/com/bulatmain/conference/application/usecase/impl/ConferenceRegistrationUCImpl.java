package com.bulatmain.conference.application.usecase.impl;

import com.bulatmain.conference.application.factory.UserFactory;
import com.bulatmain.conference.application.model.ConferenceDTO;
import com.bulatmain.conference.application.model.ConferenceRegistrationRequestData;
import com.bulatmain.conference.application.model.UserDTO;
import com.bulatmain.conference.application.port.ConferenceGateway;
import com.bulatmain.conference.application.port.UserGateway;
import com.bulatmain.conference.application.usecase.ConferenceRegistrationUC;
import com.bulatmain.conference.application.usecase.UseCase;
import com.bulatmain.conference.application.usecase.impl.exception.NoSuchUserException;
import com.bulatmain.conference.application.usecase.impl.exception.UseCaseException;
import com.bulatmain.conference.domain.conference.entity.Conference;
import com.bulatmain.conference.domain.user.entity.User;
import com.bulatmain.conference.domain.user.value.role.Organizer;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConferenceRegistrationUCImpl
        extends UseCase
        implements ConferenceRegistrationUC {
    private final UserGateway userGateway;
    private final ConferenceGateway conferenceGateway;

    private final UserFactory userFactory;

    @Override
    public void execute(ConferenceRegistrationRequestData requestData) throws UseCaseException {
        var user = getUserByEmail(requestData.getOrganizerEmail());
        user.addRole(new Organizer());
        var conf = buildConference(
                requestData.getName(),
                user
        );

        userGateway.update(UserDTO.of(user));
        conferenceGateway.register(ConferenceDTO.of(conf));
    }

    private User getUserByEmail(String email) throws UseCaseException {
        var userDTO = userGateway.findUserByEmail(email);
        if (userDTO.isEmpty()) {
            throwAndLogFormatMessage(
                    NoSuchUserException.class,
                    "Error: there are no user with such email: %s",
                    email
            );
        }
        return userFactory.build(userDTO.get());
    }

    private Conference buildConference(String name, User user) {
        try {
            return Conference.build(
                    name,
                    user
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
