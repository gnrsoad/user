package com.example.user.controller;

import com.example.user.model.user.dto.User;
import com.example.user.model.user.request.UserRequest;
import com.example.user.model.user.response.UserResponse;
import com.example.user.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping(value = "/saveUser", consumes = (MediaType.APPLICATION_JSON_VALUE))
    public UserResponse saveUser(@RequestBody UserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getName());
        user.setLastname(userRequest.getLastname());
        user.setEmail(userRequest.getEmail());
        user.setPhone(userRequest.getPhone());
        userService.createUser(user);
        UserResponse userResponse = new UserResponse();
        userResponse.setName(user.getUsername());
        userResponse.setLastname(userRequest.getLastname());
        userResponse.setEmail(userRequest.getEmail());
        userResponse.setPhone(userRequest.getPhone());
        return userResponse;
    }

    @PutMapping(value = "/editUser/{id}", consumes = (MediaType.APPLICATION_JSON_VALUE))
    public UserResponse editUser(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        User user = userService.editUser(userRequest, id);
        UserResponse userResponse = new UserResponse();
        userResponse.setName(user.getUsername());
        userResponse.setLastname(userRequest.getLastname());
        userResponse.setEmail(userRequest.getEmail());
        userResponse.setPhone(userRequest.getPhone());
        return userResponse;
    }
}
