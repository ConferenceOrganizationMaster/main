package com.bulatmain.conference.domain.common.value.email;

import com.bulatmain.conference.domain.common.value.validator.Validator;

public class EmailValidator implements Validator<String> {
    private final String patternRegex =
            "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    @Override
    public boolean check(String email) {
        return email.matches(patternRegex);
    }
}
