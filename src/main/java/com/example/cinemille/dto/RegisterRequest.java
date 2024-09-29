package com.example.cinemille.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message = "Il nome utente è obbligatorio")
    @Size(max = 50, message = "Il nome utente non può superare i 50 caratteri")
    private String username;

    @NotBlank(message = "La password è obbligatoria")
    @Size(min = 6, message = "La password deve contenere almeno 6 caratteri")
    private String password;

    @NotBlank(message = "Il ruolo è obbligatorio")
    private String role; // Esempio: "USER" o "ADMIN"
}
