package com.example.cinemille.service;

import com.example.cinemille.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> findAll();

    Movie save(Movie movie);

    Movie findById(Long id);
}
