package com.bulatmain.conference.application.usecase.impl;

import com.bulatmain.conference.application.factory.UserFactory;
import com.bulatmain.conference.application.factory.exception.IllegalInputException;
import com.bulatmain.conference.application.model.ConferenceDTO;
import com.bulatmain.conference.application.model.ConferenceRegistrationRequestData;
import com.bulatmain.conference.application.model.UserDTO;
import com.bulatmain.conference.application.port.ConferenceGateway;
import com.bulatmain.conference.application.port.UserGateway;
import com.bulatmain.conference.domain.user.entity.User;
import com.bulatmain.conference.domain.user.value.Email;
import com.bulatmain.conference.domain.user.value.Login;
import com.bulatmain.conference.domain.user.value.Password;
import com.bulatmain.conference.domain.user.value.UserId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ConferenceRegistrationUCImplTest {

    @Mock
    private UserGateway userGateway;
    @Mock
    private ConferenceGateway conferenceGateway;
    @Mock
    private UserFactory userFactory;

    private ConferenceRegistrationUCImpl conferenceRegistrationUC;

    @BeforeEach
    void initUC() {
        conferenceRegistrationUC = new ConferenceRegistrationUCImpl(
                userGateway,
                conferenceGateway,
                userFactory
        );
    }

    @Test
    public void RegisterNewConferenceEmptyRepo_NoThrow() throws IllegalInputException {
        var requestData = requestDataExample1();

        var userDTO = userDTO(requestData);

        mockUserGatewayFindUserByEmail(Optional.of(
                userDTO
        ));
        mockUserFactory(buildUser(userDTO));
        mockUserGatewayUpdate();
        mockConferenceGatewayRegister();

        Assertions.assertDoesNotThrow(
                () -> conferenceRegistrationUC.execute(requestData)
        );

    }

    private ConferenceRegistrationRequestData requestDataExample1() {
        return ConferenceRegistrationRequestData.builder()
                .name("HighLoad 2024")
                .organizerEmail("organizer@gmail.com")
                .build();
    }

    private void mockUserGatewayFindUserByEmail(Optional<UserDTO> dtoOpt) {
        Mockito.doReturn(dtoOpt)
                .when(userGateway)
                .findUserByEmail(Mockito.anyString());
    }

    private void mockUserFactory(User user) throws IllegalInputException {
        Mockito.doReturn(user)
                .when(userFactory)
                .build(Mockito.any(UserDTO.class));
    }

    private void mockUserGatewayUpdate() {
        Mockito.doNothing()
                .when(userGateway)
                .update(Mockito.any(UserDTO.class));
    }

    private void mockConferenceGatewayRegister() {
        Mockito.doNothing()
                .when(conferenceGateway)
                .register(Mockito.any(ConferenceDTO.class));
    }

    private UserDTO userDTO(ConferenceRegistrationRequestData requestData) {
        return UserDTO.builder()
                .email(requestData.getOrganizerEmail())
                .build();
    }

    private User buildUser(UserDTO userDTO) {
        var id = buildUserId(userDTO);
        var login = buildLogin(userDTO);
        var password = buildPassword(userDTO);
        return User.build(
                id, login, password
        );
    }

    private UserId buildUserId(UserDTO userDTO) {
        return new UserId(
                new Email() {
                    public String record = userDTO.getEmail();
                    @Override
                    public String getRecord() {
                        return record;
                    }
                }
        );
    }

    private Login buildLogin(UserDTO userDTO) {
        return new Login() {
            public String record = userDTO.getLogin();

            @Override
            public String getRecord() {
                return record;
            }
        };
    }

    private Password buildPassword(UserDTO userDTO) {
        return new Password() {
            public String record = userDTO.getPassword();
            @Override
            public boolean sameAs(String raw) {
                return record.equals(raw);
            }

            @Override
            public String getRecord() {
                return record;
            }
        };
    }

}




