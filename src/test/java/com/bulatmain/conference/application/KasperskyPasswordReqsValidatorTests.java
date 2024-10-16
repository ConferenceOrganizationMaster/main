package com.bulatmain.conference.application;


import com.bulatmain.conference.application.validator.KasperskyPasswordReqsValidator;
import com.bulatmain.conference.domain.common.value.validator.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KasperskyPasswordReqsValidatorTests {
    final String password1 = "Ab123456!";
    final String password2 = "abukaka";

    private Validator<String> validator;

    @BeforeEach
    void initValidator() {
        this.validator = new KasperskyPasswordReqsValidator();
    }

    @Test
    void PasswordExample1_Valid() {
        Assertions.assertTrue(validator.check(password1));
    }

    @Test
    void PasswordExample2_NotValid() {
        Assertions.assertFalse(validator.check(password2));
    }
}
