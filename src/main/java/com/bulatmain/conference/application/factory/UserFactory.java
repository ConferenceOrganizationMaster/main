package com.bulatmain.conference.application.factory;

import com.bulatmain.conference.application.factory.exception.IllegalInputException;
import com.bulatmain.conference.application.model.UserDTO;
import com.bulatmain.conference.domain.user.entity.User;
import com.bulatmain.conference.domain.user.value.UserId;

public interface UserFactory extends Factory<User, UserDTO> {
    @Override
    User build(UserDTO userDTO) throws IllegalInputException;
}
