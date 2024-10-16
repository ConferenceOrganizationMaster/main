package com.bulatmain.conference.domain.common.value.email;

import com.bulatmain.conference.domain.common.value.email.exception.IllegalEmailException;
import com.bulatmain.conference.domain.common.value.validator.Validator;

public class Email {
    private static String record;

    public Email build(String record, Validator<String> validator) throws IllegalEmailException {
        if (validator.check(record)) {
            throw new IllegalEmailException(
                    String.format("Error: illegal email: %s.", record)
            );
        }
        return new Email(record);
    }

    private Email(String record) {
        this.record = record;
    }

}
