package com.bulatmain.conference.config;

import com.bulatmain.conference.application.validator.*;
import com.bulatmain.conference.domain.user.value.Email;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.parameters.P;

@Configuration
public class ValueObjectConfig {
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

    @Bean
    public DefaultNameValidator defaultNameValidator() {
        return new DefaultNameValidator();
    }

    @Bean
    public PhoneValidator phoneValidator() {
        return new PhoneValidator();
    }
}
