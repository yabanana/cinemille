package com.example.cinemille.dto;

import lombok.Data;

@Data
public class MovieDTO {

    private Long id;
    private String title;
    private String director;
    private String genre;
    private int duration;
    private String description;
}
