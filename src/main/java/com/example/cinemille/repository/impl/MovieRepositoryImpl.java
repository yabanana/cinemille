package com.example.cinemille.repository.impl;

import com.example.cinemille.model.Movie;
import com.example.cinemille.repository.MovieRepository;
import com.example.cinemille.repository.jpa.MovieJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

    private final MovieJpaRepository movieJpaRepository;

    @Autowired
    public MovieRepositoryImpl(MovieJpaRepository movieJpaRepository) {
        this.movieJpaRepository = movieJpaRepository;
    }

    @Override
    public List<Movie> findAll() {
        return movieJpaRepository.findAll();
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return movieJpaRepository.findById(id);
    }

    @Override
    public Movie save(Movie entity) {
        return movieJpaRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        movieJpaRepository.deleteById(id);
    }
}
