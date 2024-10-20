package com.bulatmain.conference.application.model;

import com.bulatmain.conference.domain.user.entity.User;
import com.bulatmain.conference.domain.user.value.UserId;
import com.bulatmain.conference.domain.user.value.role.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    String email;
    String login;
    String password;
    String name;
    String phone;
    Collection<Role> roles;

    public UserDTO(User user) {
        email = user.getEmail().toString();
        login = user.getLogin().toString();
        password = user.getPassword().toString();
        name = user.getDetail().name().getName();
        phone = user.getDetail().phone().getRecord();
        roles = user.getRoles().getCollection();
    }

    public static UserDTO of(User user) {
        return new UserDTO(user);
    }

}
