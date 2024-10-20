package com.bulatmain.conference.application.validator;

import com.bulatmain.conference.domain.common.value.Validator;

public class DefaultNameValidator implements Validator<String> {
    private final String patternRegex
            = " *\\w* *\\w* *";
    @Override
    public boolean check(String fullName) {
        return fullName.matches(" *\\w* *\\w* *");
    }
}
