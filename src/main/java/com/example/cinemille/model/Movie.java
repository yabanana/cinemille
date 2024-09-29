package com.example.cinemille.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Il titolo è obbligatorio")
    @Size(max = 100, message = "Il titolo non può superare i 100 caratteri")
    @Column(nullable = false, length = 100)
    private String title;

    @NotBlank(message = "Il regista è obbligatorio")
    @Size(max = 50, message = "Il nome del regista non può superare i 50 caratteri")
    @Column(nullable = false, length = 50)
    private String director;

    @NotBlank(message = "Il genere è obbligatorio")
    @Size(max = 30, message = "Il genere non può superare i 30 caratteri")
    @Column(nullable = false, length = 30)
    private String genre;

    @Positive(message = "La durata deve essere positiva")
    @Column(nullable = false)
    private int duration; // durata in minuti

    @Size(max = 500, message = "La descrizione non può superare i 500 caratteri")
    @Column(length = 500)
    private String description;
}