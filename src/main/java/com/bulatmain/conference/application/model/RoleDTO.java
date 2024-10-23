package com.bulatmain.conference.application.model;

import com.bulatmain.conference.domain.user.value.role.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {
    String name;

    public RoleDTO(Role role) {
        name = role.name();
    }

    public static RoleDTO of(Role role) {
        return new RoleDTO(role);
    }
}
