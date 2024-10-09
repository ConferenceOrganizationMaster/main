package com.bulatmain.accountservice.domain.user.value;

import com.bulatmain.accountservice.domain.user.value.exception.InvalidPasswordException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class HashedPassword implements Password<HashedPassword> {
    public HashedPassword build(String password) throws InvalidPasswordException {
        if (!valid(password)) {
            throw new InvalidPasswordException(
                    String.format("Error: password %s is not valid.", password)
            );
        }
        return new HashedPassword(passwordEncoder.encode(password));
    }

    @Override
    public boolean equals(HashedPassword password) {
        return this.hash.equals(password.hash);
    }
    private final String hash;
    private final PasswordEncoder passwordEncoder =
            new BCryptPasswordEncoder();
    private final String passwordPatternRequiredRegex =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
    private HashedPassword(String hash) {
        this.hash = hash;
    }


    private boolean valid(String password) {
        return password.matches(passwordPatternRequiredRegex);
    }

}
