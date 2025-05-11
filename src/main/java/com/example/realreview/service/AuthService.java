package com.example.realreview.service;

import com.example.realreview.dto.AuthRequest;
import com.example.realreview.dto.AuthResponse;
import com.example.realreview.entity.User;
import com.example.realreview.respository.UserRepository;
import com.example.realreview.config.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authManager;

    public AuthResponse register(AuthRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists.");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());

        userRepository.save(user);

        String token = jwtUtil.generateToken(user.getUsername());

        return new AuthResponse(token, "User registered successfully.");
    }

    public AuthResponse login(AuthRequest request) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());

        Authentication authentication = authManager.authenticate(authenticationToken);

        String token = jwtUtil.generateToken(authentication);

        return new AuthResponse(token, "Login successful.");
    }
}
