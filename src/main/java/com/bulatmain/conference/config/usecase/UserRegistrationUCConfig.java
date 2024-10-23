package com.bulatmain.conference.config.usecase;

import com.bulatmain.conference.application.usecase.UserRegistrationUC;
import com.bulatmain.conference.application.usecase.impl.UserRegistrationUCImpl;
import com.bulatmain.conference.application.validator.KasperskyPasswordReqsValidator;
import com.bulatmain.conference.application.validator.EmailValidator;
import com.bulatmain.conference.application.validator.DefaultLoginValidator;
import com.bulatmain.conference.infrastructure.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserRegistrationUCConfig {
    @Bean
    public UserRegistrationUC userRegistrationUC(
            UserRepository userRepository,
            EmailValidator emailValidator,
            DefaultLoginValidator loginValidator,
            KasperskyPasswordReqsValidator kasperskyPasswordReqsValidator
    ) {
        return new UserRegistrationUCImpl(
                userRepository,
                emailValidator,
                loginValidator,
                kasperskyPasswordReqsValidator
        );
    }

}
