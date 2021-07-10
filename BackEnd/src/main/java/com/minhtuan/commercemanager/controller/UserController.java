package com.minhtuan.commercemanager.controller;

import com.minhtuan.commercemanager.model.User;
import com.minhtuan.commercemanager.services.UserService;
import com.minhtuan.commercemanager.validation.EmailExistedValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailExistedValidator emailExistedValidator;

    @GetMapping("/get-all")
    public List<User> getAllUsers() {
        return userService.getAllUser();
    }

    @PostMapping("/emailcheck")
    public ResponseEntity<?> emailCheck(@RequestBody Map<String, Object> inputData) {
        String email = (String)inputData.get("email");

        Boolean bool = emailExistedValidator.emailExists(email);

        return ResponseEntity.status(HttpStatus.OK).body(bool);
    }
}
