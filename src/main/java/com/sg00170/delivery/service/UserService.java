package com.sg00170.delivery.service;

import com.sg00170.delivery.model.User;
import com.sg00170.delivery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User signInUser(String username, String password) {
        return authenticate(username, password);
    }

    public User signUpUser(String username, String password, String confirmPassword) {
        if (!Objects.equals(password, confirmPassword)) throw new BadCredentialsException("Invalid credentials");
        String hashed = passwordEncoder.encode(password);
        User user = User.builder()
                .username(username)
                .password(hashed)
                .build();
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findOrFailByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public boolean existsByUsername(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    public User authenticate(String username, String password) {
        User user = findOrFailByUsername(username);
        if (passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        throw new BadCredentialsException("Invalid credentials");
    }
}
