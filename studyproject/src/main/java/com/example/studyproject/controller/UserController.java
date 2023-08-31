package com.example.studyproject.controller;

import com.example.studyproject.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
//    @PostMapping("/register")
//    public UserDto register(@RequestBody UserDto userDto) {
//        return userService.registerUser(userDto);
//    }
//    @PostMapping("/login")
//    public UserDto login(@RequestBody UserDto userDto) {
//        return userService.login(userDto);
//    }
}
