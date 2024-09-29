package com.example.cinemille.controller;

import com.example.cinemille.mapper.MovieMapper;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.example.cinemille.dto.MovieDTO;
import com.example.cinemille.service.MovieService;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;
    // MovieMapper importato

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieDTO> getAllMovies() {
        return movieService.findAll().stream()
                .map(MovieMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public MovieDTO createMovie(@Valid @RequestBody MovieDTO movieDTO) {
        return MovieMapper.toDTO(movieService.save(MovieMapper.toEntity(movieDTO)));
    }

    // Altri endpoint come update e delete
}
