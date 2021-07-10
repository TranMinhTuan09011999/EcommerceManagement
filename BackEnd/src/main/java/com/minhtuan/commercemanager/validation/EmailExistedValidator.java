package com.minhtuan.commercemanager.validation;

import com.minhtuan.commercemanager.model.User;
import com.minhtuan.commercemanager.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmailExistedValidator {
    @Autowired
    private UserRepository userRepository;

    public boolean emailExists(String email) {
        boolean exists = false;

        if (email != null && !StringUtils.isBlank(email)) {
            Optional<User> user = userRepository.findByEmail(email);
            if(user.isPresent())
            {
                exists = true;
            }
        }

        return exists;
    }
}
