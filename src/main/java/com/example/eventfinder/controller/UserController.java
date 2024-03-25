package com.example.eventfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.eventfinder.service.UserService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        Map<String, Object> response = new HashMap<>();

        if (username == null || password == null) {
            response.put("status", "error");
            response.put("message", "Username and password are required");
            return ResponseEntity.badRequest().body(response);
        }
        boolean isAuthenticated = userService.authenticateUser(username, password);
        if (isAuthenticated) {
            response.put("status", "success");
            response.put("message", "Login successful!");
            response.put("username", username);
            return ResponseEntity.ok(response);
        } else {
            response.put("status", "error");
            response.put("message", "Invalid username or password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> signup(@RequestBody Map<String, String> userDetails) {
        String username = userDetails.get("username");
        String email = userDetails.get("email");
        String password = userDetails.get("password");

        Map<String, Object> response = new HashMap<>();

        // Check if any of the fields are missing
        if (username == null || email == null || password == null) {
            response.put("status", "error");
            response.put("message", "Username, email, and password are required");
            return ResponseEntity.badRequest().body(response);
        }

        boolean checkEmail = userService.checkEmail(email);
        boolean checkUsername= userService.checkUsername(username);
        // Check if username or email already exists
        if (checkEmail) {
            response.put("status", "error");
            response.put("message", "Username already exists");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
        if (checkUsername) {
            response.put("status", "error");
            response.put("message", "Email already exists");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }

        Integer id=userService.insertUser(email,username,password);
        // Construct success response
        response.put("status", "success");
        response.put("userId", id);
        return ResponseEntity.ok(response);
    }

}

