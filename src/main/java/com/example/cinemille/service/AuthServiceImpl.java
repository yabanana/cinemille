package com.example.cinemille.service;

import com.example.cinemille.dto.LoginRequest;
import com.example.cinemille.dto.LoginResponse;
import com.example.cinemille.dto.RegisterRequest;
import com.example.cinemille.model.User;
import com.example.cinemille.repository.UserRepository;
import com.example.cinemille.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserRepository userRepository;
    private final CustomUserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(AuthenticationManager authenticationManager,
                           JwtTokenUtil jwtTokenUtil,
                           UserRepository userRepository,
                           CustomUserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userRepository = userRepository;
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public LoginResponse authenticateUser(LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
        User user = userRepository.findByUsername(loginRequest.getUsername());
        String token = jwtTokenUtil.generateJwtToken(user);

        return new LoginResponse(token);
    }

    @Override
    public void registerUser(RegisterRequest registerRequest) {
        // Controlla se l'utente esiste già
        if (userRepository.findByUsername(registerRequest.getUsername()) != null) {
            throw new IllegalArgumentException("Il nome utente è già in uso.");
        }

        // Codifica la password
        String encodedPassword = passwordEncoder.encode(registerRequest.getPassword());

        // Crea un nuovo utente
        User newUser = new User();
        newUser.setUsername(registerRequest.getUsername());
        newUser.setPassword(encodedPassword);
        newUser.setRole(registerRequest.getRole());

        // Salva l'utente nel database
        userRepository.save(newUser);
    }
}
