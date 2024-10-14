package com.bulatmain.conference.domain.common.value.login;

import com.bulatmain.conference.domain.common.value.validator.Validator;

public class DefaultLoginValidator implements Validator<String> {

    public final String patternRegex =
            "^[A-Za-z0-9]+([A-Za-z0-9]*|[._-]?[A-Za-z0-9]+)*$";
    @Override
    public boolean check(String login) {
        return login.matches(patternRegex);
    }
}
