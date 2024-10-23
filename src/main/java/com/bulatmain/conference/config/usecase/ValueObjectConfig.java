package com.bulatmain.conference.config.usecase;

import com.bulatmain.conference.application.validator.DefaultLoginValidator;
import com.bulatmain.conference.application.validator.EmailValidator;
import com.bulatmain.conference.application.validator.KasperskyPasswordReqsValidator;
import com.bulatmain.conference.domain.user.value.Email;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
