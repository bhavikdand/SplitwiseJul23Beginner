package com.example.splitwiseJul23Beginner.dtos;

import lombok.Data;

@Data
public class RegisterUserRequestDto {
    private String userName;
    private String password;
    private String phoneNumber;
}
