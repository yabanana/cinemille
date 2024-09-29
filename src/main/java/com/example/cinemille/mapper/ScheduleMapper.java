package com.example.cinemille.mapper;

import com.example.cinemille.dto.ScheduleDTO;
import com.example.cinemille.model.Movie;
import com.example.cinemille.model.Schedule;
import com.example.cinemille.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScheduleMapper {

    private final MovieService movieService;

    @Autowired
    public ScheduleMapper(MovieService movieService) {
        this.movieService = movieService;
    }

    public ScheduleDTO toDTO(Schedule schedule) {
        ScheduleDTO dto = new ScheduleDTO();
        dto.setId(schedule.getId());
        dto.setStartTime(schedule.getStartTime());
        dto.setMovieId(schedule.getMovie().getId());
        dto.setMovieTitle(schedule.getMovie().getTitle());
        return dto;
    }

    public Schedule toEntity(ScheduleDTO dto) {
        Schedule schedule = new Schedule();
        schedule.setStartTime(dto.getStartTime());
        Movie movie = movieService.findById(dto.getMovieId());
        schedule.setMovie(movie);
        return schedule;
    }
}
