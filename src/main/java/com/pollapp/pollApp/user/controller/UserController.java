package com.pollapp.pollApp.user.controller;

import com.pollapp.pollApp.responses.model.Response;
import com.pollapp.pollApp.user.model.User;
import com.pollapp.pollApp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    List<User> all() {
        return userService.listAllUsers();
    }

    @GetMapping("/user/{userName}")
    public List<User> findByUserName(@PathVariable  String userName) {
        return userService.findByUserName(userName);
    }
}
