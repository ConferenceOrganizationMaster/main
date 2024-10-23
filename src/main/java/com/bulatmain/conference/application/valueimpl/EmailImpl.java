package com.bulatmain.conference.application.valueimpl;

import com.bulatmain.conference.domain.common.value.Validator;
import com.bulatmain.conference.domain.user.value.Email;
import com.bulatmain.conference.domain.user.value.exception.IllegalEmailException;
import lombok.Getter;

@Getter
public class EmailImpl implements Email{
    private final String record;

    public static Email build(String record, Validator<String> validator) throws IllegalEmailException {
        if (validator.check(record)) {
            throw new IllegalEmailException(
                    String.format("Error: illegal email: %s.", record)
            );
        }
        return new EmailImpl(record);
    }

    private EmailImpl(String record) {
        this.record = record;
    }

}
