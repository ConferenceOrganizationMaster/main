package com.bulatmain.conference.domain.common.value.email;

import com.bulatmain.conference.domain.common.value.email.exception.IllegalEmailException;

public class Email {
    private static String record;

    public Email build(String record) throws IllegalEmailException {
        if (!valid(record)) {
            throw new IllegalEmailException(
                    String.format("Error: illegal email: %s.", record)
            );
        }
        return new Email(record);
    }

    private Email(String record) {
        this.record = record;
    }

    private boolean valid(String record) {
        return record.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

}
