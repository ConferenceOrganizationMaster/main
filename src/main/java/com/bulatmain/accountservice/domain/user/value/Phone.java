package com.bulatmain.accountservice.domain.user.value;

import com.bulatmain.accountservice.domain.user.value.exception.IllegalEmailException;
import com.bulatmain.accountservice.domain.user.value.exception.IllegalPhoneException;

public class Phone {

    private static String record;

    public Phone build(String record) throws IllegalPhoneException {
        if (!valid(record)) {
            throw new IllegalPhoneException(
                    String.format("Error: illegal phone: %s.", record)
            );
        }
        return new Phone(record);
    }

    private Phone(String record) {
        this.record = record;
    }

    private boolean valid(String record) {
        return record.matches("\\d{11}");
    }

}
