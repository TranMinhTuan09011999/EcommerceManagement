package com.minhtuan.commercemanager.services.ServicesImpl;

import com.minhtuan.commercemanager.converter.UserConverter;
import com.minhtuan.commercemanager.model.DTO.UserDTO;
import com.minhtuan.commercemanager.model.User;
import com.minhtuan.commercemanager.repository.UserRepository;
import com.minhtuan.commercemanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserConverter userConverter;

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<UserDTO> dtoList = new ArrayList<>();
        userRepository.findAllByOrderByIdDesc().stream().forEach(s -> {
            UserDTO dto = new UserDTO();
            dto = userConverter.toDTO(s);
            dtoList.add(dto);
        });
        return dtoList;
    }

    @Override
    public Optional findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional findUserByResetToken(String resetToken) {
        return userRepository.findByResetToken(resetToken);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
