package com.example.user.services;

import com.example.user.model.user.dto.User;
import com.example.user.model.user.request.UserRequest;
import com.example.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User editUser(UserRequest userRequest, Long id) {
        User user1 = findUser(id);
        user1.setUsername(userRequest.getName());
        user1.setLastname(userRequest.getLastname());
        user1.setEmail(userRequest.getEmail());
        user1.setPhone(userRequest.getPhone());
        return userRepository.save(user1);
    }

    private User findUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

}
