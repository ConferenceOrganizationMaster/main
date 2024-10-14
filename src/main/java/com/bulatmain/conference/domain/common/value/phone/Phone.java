package com.bulatmain.conference.domain.common.value.phone;

import com.bulatmain.conference.domain.common.value.phone.exception.IllegalPhoneException;

public class Phone {

    private static String record;

    public static Phone build(String record) throws IllegalPhoneException {
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

    private static boolean valid(String record) {
        return record.matches("\\d{11}");
    }

}
