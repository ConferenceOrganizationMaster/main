package com.bulatmain.conference.infrastructure.controller;

import com.bulatmain.conference.application.model.UserDTO;
import com.bulatmain.conference.application.model.UserRegistrationRequestData;
import com.bulatmain.conference.application.usecase.UserRegistrationUC;
import com.bulatmain.conference.application.usecase.impl.exception.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/conference")
@AllArgsConstructor
public class UserController {
    @Autowired
    private final UserRegistrationUC userRegistrationUC;

    @GetMapping("/user")
    public ResponseEntity<List<UserDTO>> getUsers() {
        return new ResponseEntity<>(new ArrayList<UserDTO>(), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationRequestData request) {
        try {
            userRegistrationUC.execute(request);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (UserAlreadyExistsException e) {
            return new ResponseEntity<>("Error: user with such email already exists.", HttpStatus.BAD_REQUEST);
        } catch (InvalidEmailException e) {
            return new ResponseEntity<>("Error: invalid email passed.", HttpStatus.BAD_REQUEST);
        } catch (InvalidLoginException e) {
            return new ResponseEntity<>("Error: invalid login passed.", HttpStatus.BAD_REQUEST);
        } catch (InvalidPasswordException e) {
            return new ResponseEntity<>("Error: invalid password passed.", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Unknown error.", HttpStatus.BAD_REQUEST);
        }
    }



}
