package com.bulatmain.conference.application.model;

import lombok.Data;

@Data
public class UserRegistrationRequestData {
    String email;
    String login;
    String password;

    public UserDTO toDTO() {
        return UserDTO.builder()
                .email(email)
                .login(login)
                .password(password)
                .name(null)
                .phone(null)
                .build();
    }
}
