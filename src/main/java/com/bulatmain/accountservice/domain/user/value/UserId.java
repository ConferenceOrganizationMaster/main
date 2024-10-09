package com.bulatmain.accountservice.domain.user.value;

import com.bulatmain.accountservice.domain.common.value.Id;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public record UserId(Email email) implements Id {
    public String toString() {
        return email.toString();
    }
}
