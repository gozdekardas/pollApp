package com.pollapp.controller;

import com.pollapp.model.User;
import com.pollapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/getUserType/{userName}/{password}")
    public ResponseEntity<String> getUserType(@PathVariable String userName, @PathVariable String password) {
        String userType;
        try {
            userType = userService.getUserType(userName,password);
        } catch (Exception e) {
            userType = "notfound";
        }
        return ResponseEntity.ok(userType);
    }
}
