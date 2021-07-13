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

    @GetMapping("/get-all")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        Optional<User> temp = userService.findById(id);
        if (Objects.isNull(temp)) {
            throw new RuntimeException("User not found");
        }
        User user = new User();
        user = temp.get();
        return ResponseEntity.ok().body(userConverter.toDTO(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserDTO userDto) {
        Optional<User> temp = userService.findById(id);
        if (Objects.isNull(temp)) {
            throw new RuntimeException(("User not found"));
        }
        User user = temp.get();
        user.setUsername(userDto.getUsername());
        user.setPhone(userDto.getPhone());
        user.setAddress(userDto.getAddress());
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        System.out.println(userDto);

        System.out.println(user);
        userService.save(user);
        return ResponseEntity.ok().body("User has updated successfully");
    }

    @PostMapping("/emailcheck")
    public ResponseEntity<?> emailCheck(@RequestBody Map<String, Object> inputData) {
        String email = (String)inputData.get("email");

        Boolean bool = emailExistedValidator.emailExists(email);

        return ResponseEntity.status(HttpStatus.OK).body(bool);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        User user = new User();
        Optional<User> temp = userService.findById(id);
        if (Objects.isNull(temp)) {
            throw new RuntimeException(("User not found"));
        }
        user = temp.get();
        System.out.println(user.toString());
        if (user.getOrders().stream().count() == 0) {
            userService.delete(id);
            return ResponseEntity.badRequest().body("User has no order");
        }
        user.setDeletestatus(1);
        userService.save(user);
        return ResponseEntity.ok().body("OK");
    }
}
