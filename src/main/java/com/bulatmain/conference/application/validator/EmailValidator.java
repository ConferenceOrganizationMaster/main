package com.bulatmain.conference.application.validator;

import com.bulatmain.conference.domain.common.value.Validator;

public class EmailValidator implements Validator<String> {
    private final String patternRegex =
            "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    @Override
    public boolean check(String email) {
        return email.matches(patternRegex);
    }
}
