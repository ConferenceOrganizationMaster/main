package com.bulatmain.conference.domain.user.value;

import com.bulatmain.conference.domain.user.value.exception.IllegalEmailException;
import com.bulatmain.conference.domain.common.value.validator.Validator;
import lombok.Getter;

@Getter
public class Email {
    private final String record;

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
