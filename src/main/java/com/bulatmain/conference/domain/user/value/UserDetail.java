package com.bulatmain.conference.domain.user.value;

import com.bulatmain.conference.domain.common.value.name.Name;
import com.bulatmain.conference.domain.common.value.phone.Phone;

public record UserDetail(Name name, Phone phone) {
    public UserDetail fromRaw(String fullName, String phone) {
        return new UserDetail(Name.build(fullName), Phone.build(phone));
    }
}
