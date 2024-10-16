package com.bulatmain.conference.infrastructure.repository;

import com.bulatmain.conference.application.model.UserDTO;
import com.bulatmain.conference.application.port.UserGateway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends
        UserGateway, JpaRepository<UserDTO, String> {
    Optional<UserDTO> findUserByEmail(String email);
    default void register(UserDTO dto) {
        save(dto);
    }

}
