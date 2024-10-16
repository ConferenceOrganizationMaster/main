package com.bulatmain.conference.application.validator;

import com.bulatmain.conference.domain.common.value.validator.Validator;

public class KasperskyPasswordReqsValidator implements Validator<String> {

    @Override
    public boolean check(String password) {
        return password.matches(passwordPatternRequiredRegex);
    }

    private static final String passwordPatternRequiredRegex =
            "^(?=.*[a-zа-я])(?=.*[A-ZА-Я])(?=.*\\d)(?=.*[~!\\?@#$%^&*\\_\\-\\+\\(\\)\\{\\}\\[\\]<>\\/\\\\|\"'.:;]).{8,128}$";
}
