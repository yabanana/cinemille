package com.example.cinemille.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ScheduleDTO {

    private Long id;
    private LocalDateTime startTime;
    private Long movieId;
    private String movieTitle;
}
