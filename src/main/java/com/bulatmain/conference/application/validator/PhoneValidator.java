package com.bulatmain.conference.application.validator;

import com.bulatmain.conference.domain.common.value.validator.Validator;

public class PhoneValidator implements Validator<String> {
    private final String patternRegex
            = "\\d{11}";
    @Override
    public boolean check(String phone) {
        return phone.matches(patternRegex);
    }
}
