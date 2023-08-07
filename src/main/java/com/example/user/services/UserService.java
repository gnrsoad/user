package com.example.user.services;

import com.example.user.model.user.dto.User;
import com.example.user.model.user.request.UserRequest;

public interface UserService {
    User createUser(User user);
    User editUser(UserRequest userRequest, Long id);
}
