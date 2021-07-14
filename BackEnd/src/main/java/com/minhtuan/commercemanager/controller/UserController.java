package com.minhtuan.commercemanager.controller;

import com.minhtuan.commercemanager.converter.UserConverter;
import com.minhtuan.commercemanager.message.request.SignupRequest;
import com.minhtuan.commercemanager.model.DTO.UserDTO;
import com.minhtuan.commercemanager.model.User;
import com.minhtuan.commercemanager.services.UserService;
import com.minhtuan.commercemanager.validation.EmailExistedValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    UserConverter userConverter;

    @Autowired
    private EmailExistedValidator emailExistedValidator;

    @PostMapping("/emailcheck")
    public ResponseEntity<?> emailCheck(@RequestBody Map<String, Object> inputData) {
        String email = (String)inputData.get("email");

        Boolean bool = emailExistedValidator.emailExists(email);

        return ResponseEntity.status(HttpStatus.OK).body(bool);
    }
}
