package com.example.cinemille.controller;

import com.example.cinemille.dto.JwtResponse;
import com.example.cinemille.dto.RegisterRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.cinemille.dto.LoginRequest;
import com.example.cinemille.dto.LoginResponse;
import com.example.cinemille.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        String token = String.valueOf(authService.authenticateUser(loginRequest));  // Autenticazione e generazione del token
        return ResponseEntity.ok(new JwtResponse(token));  // Restituisci una risposta con il token
    }


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
        authService.registerUser(registerRequest);
        return ResponseEntity.ok("Registrazione completata con successo.");
    }
}
