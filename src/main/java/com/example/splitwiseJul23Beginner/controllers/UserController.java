package com.example.splitwiseJul23Beginner.controllers;

import com.example.splitwiseJul23Beginner.dtos.RegisterUserRequestDto;
import com.example.splitwiseJul23Beginner.models.User;
import com.example.splitwiseJul23Beginner.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    //TODO return RegisterUserResponseDTO which doesn't have password
    public User registerUser(RegisterUserRequestDto dto){
        return this.userService.registerUser(dto.getUserName(), dto.getPhoneNumber(), dto.getPassword());
    }
}
