package com.example.splitwiseJul23Beginner.commands;

import com.example.splitwiseJul23Beginner.controllers.UserController;
import com.example.splitwiseJul23Beginner.dtos.RegisterUserRequestDto;
import com.example.splitwiseJul23Beginner.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserCommand implements Command {

    public static final String REGISTER_USER_COMMAND = "Register";
    private final UserController userController;

    @Autowired
    public RegisterUserCommand(UserController userController) {
        CommandRegistry.getInstance().addCommand(REGISTER_USER_COMMAND, this);
        this.userController = userController;
    }

    @Override
    public void execute(String input) {
        String[] splits = input.split(" ");
        if(validateCommand(splits)){

            String username = splits[1];
            String phoneNumber = splits[2];
            String password = splits[3];

            RegisterUserRequestDto dto = new RegisterUserRequestDto();
            dto.setPassword(password);
            dto.setUserName(username);
            dto.setPhoneNumber(phoneNumber);

            User user = userController.registerUser(dto);
            System.out.println(user);
        } else {
            throw new RuntimeException("Incorrect Register user command, please look at syntax");
        }
    }

    public boolean validateCommand(String[] splits){
        return splits.length == 4 && splits[0].equals(REGISTER_USER_COMMAND);
    }
}
