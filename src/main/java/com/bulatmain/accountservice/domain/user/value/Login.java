package com.bulatmain.accountservice.domain.user.value;

import com.bulatmain.accountservice.domain.user.value.exception.InvalidLoginException;

public class Login {
    private final String record;
    public final String patternRegex =
            "^[A-Za-z0-9]+([A-Za-z0-9]*|[._-]?[A-Za-z0-9]+)*$";

    public Login build(String record) throws InvalidLoginException {
        if (!record.matches(patternRegex)) {
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
