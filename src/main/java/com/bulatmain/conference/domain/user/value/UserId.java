package com.bulatmain.conference.domain.user.value;

import com.bulatmain.conference.domain.common.value.id.Id;

public record UserId(Email email) implements Id {
    public String toString() {
        return email.toString();
    }
}
