package com.bulatmain.conference.config;

import com.bulatmain.conference.application.usecase.UserRegistrationUC;
import com.bulatmain.conference.application.usecase.impl.UserRegistrationUCImpl;
import com.bulatmain.conference.application.validator.KasperskyPasswordReqsValidator;
import com.bulatmain.conference.application.validator.EmailValidator;
import com.bulatmain.conference.application.validator.DefaultLoginValidator;
import com.bulatmain.conference.infrastructure.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
    @Bean
    public UserRegistrationUC userRegistrationUC(UserRepository userRepository) {
        return new UserRegistrationUCImpl(
                userRepository,
                emailValidator(),
                defaultLoginValidator(),
                kasperskyPasswordReqsValidator()
        );
    }

    @Bean
    public EmailValidator emailValidator() {
        return new EmailValidator();
    }
    @Bean
    public DefaultLoginValidator defaultLoginValidator() {
        return new DefaultLoginValidator();
    }
    @Bean
    public KasperskyPasswordReqsValidator kasperskyPasswordReqsValidator() {
        return new KasperskyPasswordReqsValidator();
    }

}
