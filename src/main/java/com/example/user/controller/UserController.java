package com.example.user.controller;

import com.example.user.model.user.dto.User;
import com.example.user.model.user.request.UserRequest;
import com.example.user.model.user.response.UserResponse;
import com.example.user.services.UserServices;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserServices userServices;
    @GetMapping(value = "/saveUser", consumes = (MediaType.APPLICATION_JSON_VALUE))
    public UserResponse saveUser(@RequestBody UserRequest userRequest) {
        User user = new User();
        user.setUserName(userRequest.getName());
        userServices.saveUser(user);
        UserResponse userResponse = new UserResponse();
        userResponse.setName(user.getUserName());
        userResponse.setLastname(userRequest.getLastname());
        userResponse.setEmail(userRequest.getEmail());
        userResponse.setPhone(userRequest.getPhone());
        return userResponse;
    }
//    @DeleteMapping(value = "/deleteUser")
//    public void deleteUser(Integer userId){
//
//    }
}
