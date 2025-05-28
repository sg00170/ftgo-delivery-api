package com.sg00170.delivery.controller;

import com.sg00170.delivery.model.User;
import com.sg00170.delivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/me")
    public ResponseEntity<User> getMyInfo(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return ResponseEntity.ok(user);
    }

    // 고객 생성
    @PostMapping
    public Long createConsumer(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // 고객 확인
    @PostMapping("/{id}/verification")
    public boolean verifyConsumerDetails() {
        return true;
    }
}
