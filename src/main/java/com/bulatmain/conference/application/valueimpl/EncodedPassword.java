package com.bulatmain.conference.application.valueimpl;

import com.bulatmain.conference.domain.user.value.Password;
import com.bulatmain.conference.domain.user.value.exception.InvalidPasswordException;
import com.bulatmain.conference.domain.common.value.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Component
public class EncodedPassword implements Password {
    public static EncodedPassword build(String password, Validator<String> validator) throws InvalidPasswordException {
        if (!validator.check(password)) {
            throw new InvalidPasswordException(
                    String.format("Error: password %s is not valid.", password)
            );
        }
        return new EncodedPassword(passwordEncoder.encode(password));
    }

    @Override
    public boolean sameAs(String raw) {
        return passwordEncoder.matches(raw, hash);
    }

    @Override
    public String getRecord() {
        return hash;
    }

    private final String hash;
    private static PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        EncodedPassword.passwordEncoder = passwordEncoder;
    }
    private EncodedPassword(String hash) {
        this.hash = hash;
    }


}
