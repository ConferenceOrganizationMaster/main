package com.bulatmain.conference.domain.common.value.phone;

import com.bulatmain.conference.domain.common.value.phone.exception.IllegalPhoneException;
import com.bulatmain.conference.domain.common.value.validator.Validator;
import lombok.Getter;

@Getter
public class Phone {

    private final String record;

    public static Phone build(String record, Validator<String> validator) throws IllegalPhoneException {
        if (!validator.check(record)) {
            throw new IllegalPhoneException(
                    String.format("Error: illegal phone: %s.", record)
            );
        }
        return new Phone(record);
    }

    private Phone(String record) {
        this.record = record;
    }

}
