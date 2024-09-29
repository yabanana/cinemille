package com.example.cinemille.service;

import com.example.cinemille.model.Schedule;

import java.time.LocalDateTime;
import java.util.List;

public interface ScheduleService {

    List<Schedule> findAll();

    List<Schedule> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);

    Schedule save(Schedule schedule);
}
