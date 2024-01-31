package com.example.demoaiprogrammer.copilot.demo.user;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //create register user method of User using method registerUser from UserService and return ResponseEntity
    public void registerUser(User user) {
        userService.registerUser(user);
    }


    //create delete user method using method deleteUser from UserService and return ResponseEntity
    public void deleteUser(User user) {
        userService.deleteUser(user);
    }

}
