package com.bulatmain.conference.infrastructure.repository;

import com.bulatmain.conference.application.model.UserDTO;
import com.bulatmain.conference.application.port.UserGateway;
import com.bulatmain.conference.infrastructure.repository.mapping.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends
        UserGateway, JpaRepository<UserTable, String> {
    @Override
    default Optional<UserDTO> findUserByEmail(String email) {
        var userTableOpt = findById(email);
        if (userTableOpt.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(
                    userTableOpt.get().toDTO()
            );
        }
    }
    @Override
    default void register(UserDTO dto) {
        save(UserTable.fromDTO(dto));
    }

}
