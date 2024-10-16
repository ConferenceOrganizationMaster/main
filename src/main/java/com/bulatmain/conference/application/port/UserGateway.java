package com.bulatmain.conference.application.port;

import com.bulatmain.conference.application.model.UserDTO;

import java.util.Optional;

public interface UserGateway {
    Optional<UserDTO> findUserByEmail(String email);

    void register(UserDTO requestData);
}
