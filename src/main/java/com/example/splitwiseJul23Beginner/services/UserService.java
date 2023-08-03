package com.example.splitwiseJul23Beginner.services;

import com.example.splitwiseJul23Beginner.models.User;
import com.example.splitwiseJul23Beginner.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String userName, String phoneNumber, String password){
        User user = new User();
        user.setName(userName);
        //TODO Generate encoded password using BCrypt
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        return this.userRepository.save(user);
    }
}
