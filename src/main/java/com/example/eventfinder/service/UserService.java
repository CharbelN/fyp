package com.example.eventfinder.service;

import com.example.eventfinder.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.eventfinder.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public boolean authenticateUser(String username, String password) {
        User existingUser = userRepository.findByUsernameAndPassword(username, password);
        return existingUser != null;
    }
    public boolean checkEmail(String email){
        return userRepository.existsByEmail(email);
    }
    public boolean checkUsername(String username){
        return userRepository.existsByUsername(username);
    }
    public Integer insertUser(String email, String username, String password){
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setUsername(username);
        newUser.setPassword(password);
        userRepository.save(newUser);
        return newUser.getUser_Id();

    }



}
