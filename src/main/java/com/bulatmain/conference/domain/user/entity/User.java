package com.bulatmain.conference.domain.user.entity;

import com.bulatmain.conference.domain.user.value.Email;
import com.bulatmain.conference.domain.user.value.Login;
import com.bulatmain.conference.domain.user.value.Password;
import com.bulatmain.conference.domain.user.value.detail.UserDetail;
import com.bulatmain.conference.domain.user.value.UserId;
import com.bulatmain.conference.domain.user.value.role.Role;
import com.bulatmain.conference.domain.user.value.role.Roles;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User {
    @Getter
    private final UserId id;
    @Getter
    private Login login;
    @Getter
    private Password password;
    @Getter
    private UserDetail detail;
    @Getter
    private Roles roles;

    public void addRole(Role role) {
        roles.add(role);
    }

    public boolean hasRole(Class<? extends Role> roleClass) {
        return roles.has(roleClass);
    }

    public static User build(UserId id, Login login, Password password) {
        return build(id, login, password, null);
    }

    public static User build(UserId id, Login login, Password password, UserDetail userDetail) {
        return new User(id, login, password, userDetail);
    }

    private User(UserId id, Login login, Password password, UserDetail detail) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.detail = detail;
    }

    public Email getEmail() {
        return id.email();
    }


}
