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

@Getter
@Setter
public class User {
    private final UserId id;
    private Login login;
    private Password password;
    private UserDetail detail;
    private Roles roles = new Roles();

    public void addRole(Role role) {
        roles.add(role);
    }

    public boolean hasRole(Class<? extends Role> roleClass) {
        return roles.has(roleClass);
    }

    public static User build(UserId id, Login login, Password password) {
        return new User(id, login, password);
    }

    private User(UserId id, Login login, Password password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public Email getEmail() {
        return id.email();
    }


}
