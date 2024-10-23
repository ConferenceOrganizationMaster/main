package com.bulatmain.conference.config.usecase;

import com.bulatmain.conference.application.factory.UserFactory;
import com.bulatmain.conference.application.factory.impl.UserFactoryImpl;
import com.bulatmain.conference.application.port.ConferenceGateway;
import com.bulatmain.conference.application.port.UserGateway;
import com.bulatmain.conference.application.usecase.ConferenceRegistrationUC;
import com.bulatmain.conference.application.usecase.impl.ConferenceRegistrationUCImpl;
import com.bulatmain.conference.application.validator.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConferenceRegistrationUCConfig {
    @Bean
    public ConferenceRegistrationUC conferenceRegistrationUC(
            UserGateway userGateway,
            ConferenceGateway conferenceGateway,
            UserFactory userFactory
    ) {
        return new ConferenceRegistrationUCImpl(
                userGateway,
                conferenceGateway,
                userFactory
        );
    }

    @Bean
    public UserFactory userFactory(
            EmailValidator emailValidator,
            DefaultLoginValidator loginValidator,
            KasperskyPasswordReqsValidator kasperskyPasswordReqsValidator,
            DefaultNameValidator nameValidator,
            PhoneValidator phoneValidator
    ) {
        return new UserFactoryImpl(
                emailValidator,
                loginValidator,
                kasperskyPasswordReqsValidator,
                nameValidator,
                phoneValidator
        );
    }
}
