package com.example.cinemille.service;

import com.example.cinemille.dto.LoginRequest;
import com.example.cinemille.dto.LoginResponse;
import com.example.cinemille.dto.RegisterRequest;

public interface AuthService {

    LoginResponse authenticateUser(LoginRequest loginRequest);

    void registerUser(RegisterRequest registerRequest);  // Nuovo metodo per la registrazione
}
