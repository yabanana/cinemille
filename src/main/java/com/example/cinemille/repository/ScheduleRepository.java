package com.example.cinemille.repository;

import com.example.cinemille.model.Schedule;
import java.time.LocalDateTime;
import java.util.List;

public interface ScheduleRepository extends GenericRepository<Schedule, Long> {

    List<Schedule> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);
}
