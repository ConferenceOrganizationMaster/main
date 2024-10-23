package com.bulatmain.conference.application.usecase.impl;

import com.bulatmain.conference.application.model.UserDTO;
import com.bulatmain.conference.application.model.UserRegistrationRequestData;
import com.bulatmain.conference.application.port.UserGateway;
import com.bulatmain.conference.application.usecase.impl.exception.UserAlreadyExistsException;
import com.bulatmain.conference.domain.common.value.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;


@ExtendWith(MockitoExtension.class)
public class UserRegistrationUCImplTest {
    @Mock
    private UserGateway userGateway;
    @Mock
    private Validator<String> emailValidator;
    @Mock
    private Validator<String> loginValidator;
    @Mock
    private Validator<String> passwordValidator;

    private UserRegistrationUCImpl userRegistrationUC;

    @BeforeEach
    void initUC() {
        userRegistrationUC = new UserRegistrationUCImpl(
                userGateway,
                emailValidator,
                loginValidator,
                passwordValidator
        );
    }

    @Test
    public void RegisterNewValidUserEmptyRepo_NoThrow() {
        var requestData = requestDataExample1();

        mockGatewayRegister();
        mockValidators(
                true,
                true,
                true
        );

        Assertions.assertDoesNotThrow(
                () -> userRegistrationUC.execute(requestData));
    }

    @Test
    public void RegisterUserWithExistingEmail_ThrowsException() {
        var requestData = requestDataExample1();

        mockGatewayFindUserByEmail(requestData.toDTO());
        mockGatewayRegister();
        mockValidators(
                true,
                true,
                true
        );

        Assertions.assertThrows(
                UserAlreadyExistsException.class,
                () -> userRegistrationUC.execute(requestData)
        );
    }

    private UserRegistrationRequestData requestDataExample1() {
        return  UserRegistrationRequestData.builder()
                .email("exampe@gmail.com")
                .login("example.login")
                .password("example.password123#")
                .build();
    }

    private void mockGatewayFindUserByEmail(UserDTO userDTO) {
        Mockito.doReturn(Optional.ofNullable(userDTO))
                .when(userGateway)
                .findUserByEmail(Mockito.anyString());
    }

    private void mockGatewayRegister() {
        Mockito.lenient()
                .doNothing()
                .when(userGateway)
                .register(Mockito.any(UserDTO.class));
    }

    private void mockValidators(
            boolean forEmail,
            boolean forLogin,
            boolean forPassword
    ) {
        mockValidator(emailValidator, forEmail);
        mockValidator(loginValidator, forLogin);
        mockValidator(passwordValidator, forPassword);
    }

    private void mockValidator(Validator<String> validator, boolean returned) {
        Mockito.lenient()
                .doReturn(returned)
                .when(validator)
                .check(Mockito.anyString());
    }
}
