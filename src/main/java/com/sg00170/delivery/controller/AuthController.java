package com.sg00170.delivery.controller;

import com.sg00170.delivery.dto.request.auth.SignInRequest;
import com.sg00170.delivery.dto.request.auth.SignUpRequest;
import com.sg00170.delivery.model.User;
import com.sg00170.delivery.service.UserService;
import com.sg00170.delivery.util.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/sign-in")
    public ResponseEntity<Map<String, String>> signIn(@Valid @RequestBody SignInRequest request) {
        User user = userService.signInUser(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(Collections.singletonMap("token", jwtUtil.generateToken(user)));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<Map<String, String>> signUp(@Valid @RequestBody SignUpRequest request) {
        User user = userService.signUpUser(request.getUsername(), request.getPassword(), request.getConfirmPassword());
        return ResponseEntity.ok(Collections.singletonMap("token", jwtUtil.generateToken(user)));
    }
}
