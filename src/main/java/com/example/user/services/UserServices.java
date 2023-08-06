package com.example.user.services;

import com.example.user.model.user.dto.User;
import com.example.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServices {
    private final UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
