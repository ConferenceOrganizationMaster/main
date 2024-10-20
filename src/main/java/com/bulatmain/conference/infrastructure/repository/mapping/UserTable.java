package com.bulatmain.conference.infrastructure.repository.mapping;

import com.bulatmain.conference.application.model.UserDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_entity")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserTable {
    @Id
    String email;
    String login;
    String password;
    String name;
    String phone;

    public UserDTO toDTO() {
        return UserDTO.builder()
                .email(getEmail())
                .login(getLogin())
                .password(getPassword())
                .name(getName())
                .phone(getPhone())
                .build();
    }

    public static UserTable fromDTO(UserDTO userDTO) {
        return UserTable.builder()
                .email(userDTO.getEmail())
                .login(userDTO.getLogin())
                .password(userDTO.getPassword())
                .name(userDTO.getName())
                .phone(userDTO.getPhone())
                .build();
    }
}
