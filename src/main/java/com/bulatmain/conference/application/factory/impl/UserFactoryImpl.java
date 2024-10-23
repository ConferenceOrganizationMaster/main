package com.bulatmain.conference.application.factory.impl;

import com.bulatmain.conference.application.factory.UserFactory;
import com.bulatmain.conference.application.factory.exception.IllegalInputException;
import com.bulatmain.conference.application.model.UserDTO;
import com.bulatmain.conference.application.validator.DefaultLoginValidator;
import com.bulatmain.conference.application.validator.EmailValidator;
import com.bulatmain.conference.application.valueimpl.EmailImpl;
import com.bulatmain.conference.application.valueimpl.EncodedPassword;
import com.bulatmain.conference.application.valueimpl.LoginImpl;
import com.bulatmain.conference.domain.common.value.Validator;
import com.bulatmain.conference.domain.user.entity.User;
import com.bulatmain.conference.domain.user.value.Login;
import com.bulatmain.conference.domain.user.value.Password;
import com.bulatmain.conference.domain.user.value.UserId;
import com.bulatmain.conference.domain.user.value.detail.Name;
import com.bulatmain.conference.domain.user.value.detail.Phone;
import com.bulatmain.conference.domain.user.value.detail.UserDetail;
import com.bulatmain.conference.domain.user.value.detail.exception.IllegalNameException;
import com.bulatmain.conference.domain.user.value.detail.exception.IllegalPhoneException;
import com.bulatmain.conference.domain.user.value.exception.IllegalEmailException;
import com.bulatmain.conference.domain.user.value.exception.InvalidLoginException;
import com.bulatmain.conference.domain.user.value.exception.InvalidPasswordException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserFactoryImpl implements UserFactory {
    private final Validator<String> emailValidator;
    private final Validator<String> loginValidator;
    private final Validator<String> passwordValidator;

    private final Validator<String> nameValidator;

    private final Validator<String> phoneValidator;


    @Override
    public User build(UserDTO userDTO) throws IllegalInputException {
        try {
            var user = User.build(
                    getUserId(userDTO),
                    getLogin(userDTO),
                    getPassword(userDTO)
            );
            user.setDetail(getDetail(userDTO));
            return user;
        } catch (IllegalEmailException | InvalidLoginException | InvalidPasswordException |
                 IllegalPhoneException | IllegalNameException e) {
            throw new IllegalInputException(e.getMessage());
        }
    }

    private UserId getUserId(UserDTO userDTO) throws IllegalEmailException {
        return new UserId(EmailImpl.build(
                userDTO.getEmail(),
                emailValidator
        ));
    }

    private Login getLogin(UserDTO userDTO) throws InvalidLoginException {
        return LoginImpl.build(
                userDTO.getLogin(),
                loginValidator
        );
    }

    private Password getPassword(UserDTO userDTO) throws InvalidPasswordException {
        return EncodedPassword.build(
                userDTO.getPassword(),
                passwordValidator
        );
    }

    private UserDetail getDetail(UserDTO userDTO) throws IllegalNameException, IllegalPhoneException {
        return new UserDetail(
                getName(userDTO),
                getPhone(userDTO)
        );
    }

    private Name getName(UserDTO userDTO) throws IllegalNameException {
        if (userDTO.getName() != null) {
            return Name.build(
                    userDTO.getName(),
                    nameValidator
            );
        } else {
            return null;
        }
    }


    private Phone getPhone(UserDTO userDTO) throws IllegalPhoneException {
        if (userDTO.getPhone() != null) {
            return Phone.build(
                    userDTO.getPhone(),
                    phoneValidator
            );
        } else {
            return null;
        }
    }
}
