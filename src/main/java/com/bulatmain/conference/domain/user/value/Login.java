package com.bulatmain.conference.domain.user.value;

import com.bulatmain.conference.domain.user.value.exception.InvalidLoginException;
import com.bulatmain.conference.domain.common.value.validator.Validator;
import lombok.Getter;

@Getter
public class Login {
    private final String record;

    public Login build(String record, Validator<String> validator) throws InvalidLoginException {
        if (!validator.check(record)) {
            throw new InvalidLoginException(
                    String.format("Error: login %s does not match the conditions.", record)
            );
        }
        return new Login(record);
    }

    private Login(String record) {
        this.record = record;
    }

    public String toString() {
        return record;
    }
}
