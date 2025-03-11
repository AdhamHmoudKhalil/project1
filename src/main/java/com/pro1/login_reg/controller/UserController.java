package com.pro1.login_reg.controller;

import com.pro1.login_reg.model.User;
import com.pro1.login_reg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/olla")
    public String test() {
        return "hallo";
    }

    @GetMapping("/alleUser")
    public ResponseEntity<List<User>> getAllUser() {
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = service.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/user/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username) {
        service.delete(username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/user/{username}")
    public ResponseEntity<User> updateUser(@PathVariable String username,
                                           @RequestBody User user) {

        User updatedUser = service.updateUser(username, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}