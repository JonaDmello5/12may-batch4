package com.example.realreview.controller;

import com.example.realreview.dto.AuthRequest;
import com.example.realreview.dto.AuthResponse;
import com.example.realreview.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
    private AuthService authService;
	
	@PostMapping("/register")
	public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest request) {
	    return ResponseEntity.ok(authService.register(request));
	}

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        AuthResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }
}
