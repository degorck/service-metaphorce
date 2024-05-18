package com.meraphorce.services;

import com.meraphorce.models.EmptyResponse;
import com.meraphorce.models.User;
import com.meraphorce.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public  List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(String id){
        return userRepository.getById(id);
    }

    public EmptyResponse deleteUser(String id){
        userRepository.deleteById(id);
        return EmptyResponse.builder()
                .message("User deleted")
                .build();
    }

    public User updateUser(String id, User user){
        User updatedUser = userRepository.getById(id);
        updatedUser.setName(user.getName());
        updatedUser.setEmail(user.getEmail());
        return userRepository.save(user);
    }
}
