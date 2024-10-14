package com.bulatmain.conference.domain.user.entity;

import com.bulatmain.conference.domain.common.value.login.Login;
import com.bulatmain.conference.domain.common.value.password.Password;
import com.bulatmain.conference.domain.user.value.UserDetail;
import com.bulatmain.conference.domain.user.value.UserId;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private final UserId id;
    private Login login;
    private Password password;
    private UserDetail detail;

    public User build(UserId id, Login login, Password password) {
        return build(id, login, password, null);
    }

    public User build(UserId id, Login login, Password password, UserDetail userDetail) {
        return new User(id, login, password, userDetail);
    }

    private User(UserId id, Login login, Password password, UserDetail detail) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.detail = detail;
    }



}
