package com.example.user.controller;

import com.example.user.model.user.dto.User;
import com.example.user.model.user.request.UserRequest;
import com.example.user.model.user.response.UserResponse;
import com.example.user.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping(value = "/saveUser", consumes = (MediaType.APPLICATION_JSON_VALUE))
    public UserResponse saveUser(@RequestBody UserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getName());
        userService.createUser(user);
        UserResponse userResponse = new UserResponse();
        userResponse.setName(user.getUsername());
        userResponse.setLastname(userRequest.getLastname());
        userResponse.setEmail(userRequest.getEmail());
        userResponse.setPhone(userRequest.getPhone());
        return userResponse;
    }
}
