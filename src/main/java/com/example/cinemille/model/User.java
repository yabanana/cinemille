package com.example.cinemille.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Il nome utente è obbligatorio")
    @Size(max = 50, message = "Il nome utente non può superare i 50 caratteri")
    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @NotBlank(message = "La password è obbligatoria")
    @Size(min = 6, message = "La password deve contenere almeno 6 caratteri")
    @Column(nullable = false)
    private String password;

    @NotBlank(message = "Il ruolo è obbligatorio")
    @Column(nullable = false)
    private String role;
}