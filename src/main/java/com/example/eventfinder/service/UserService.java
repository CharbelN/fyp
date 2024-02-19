package com.example.eventfinder.service;

import com.example.eventfinder.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.eventfinder.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean authenticateUser(String email, String password) {
        User existingUser = userRepository.findByEmailAndPassword(email, password);
        return existingUser != null;
    }
}
