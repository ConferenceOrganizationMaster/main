package com.bulatmain.conference.application.valueimpl;

import com.bulatmain.conference.domain.common.value.Validator;
import com.bulatmain.conference.domain.user.value.Login;
import com.bulatmain.conference.domain.user.value.exception.InvalidLoginException;
import lombok.Getter;

@Getter
public class LoginImpl implements Login {
    private final String record;

    public static Login build(String record, Validator<String> validator) throws InvalidLoginException {
        if (!validator.check(record)) {
            throw new InvalidLoginException(
                    String.format("Error: login %s does not match the conditions.", record)
            );
        }
        return new LoginImpl(record);
    }

    private LoginImpl(String record) {
        this.record = record;
    }

    public String toString() {
        return record;
    }
}
