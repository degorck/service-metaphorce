package com.meraphorce.controllers;

import com.meraphorce.models.EmptyResponse;
import com.meraphorce.models.User;
import com.meraphorce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<User> getUserById(String id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping
    @RequestMapping("/{id}")
    public ResponseEntity<User> updateUser(String id, @RequestBody User user){
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @DeleteMapping
    @RequestMapping("/{id}")
    public ResponseEntity<EmptyResponse> deleteUser(String id){
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
