package com.example.cinemille.mapper;

import com.example.cinemille.dto.MovieDTO;
import com.example.cinemille.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public static MovieDTO toDTO(Movie movie) {
        MovieDTO dto = new MovieDTO();
        dto.setId(movie.getId());
        dto.setTitle(movie.getTitle());
        dto.setDirector(movie.getDirector());
        dto.setGenre(movie.getGenre());
        dto.setDuration(movie.getDuration());
        dto.setDescription(movie.getDescription());
        return dto;
    }

    public static Movie toEntity(MovieDTO dto) {
        Movie movie = new Movie();
        movie.setTitle(dto.getTitle());
        movie.setDirector(dto.getDirector());
        movie.setGenre(dto.getGenre());
        movie.setDuration(dto.getDuration());
        movie.setDescription(dto.getDescription());
        return movie;
    }
}
