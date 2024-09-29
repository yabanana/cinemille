package com.example.cinemille.controller;

import com.example.cinemille.dto.ScheduleDTO;
import com.example.cinemille.mapper.ScheduleMapper;
import com.example.cinemille.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final ScheduleMapper scheduleMapper;

    @Autowired
    public ScheduleController(ScheduleService scheduleService, ScheduleMapper scheduleMapper) {
        this.scheduleService = scheduleService;
        this.scheduleMapper = scheduleMapper;
    }

    @GetMapping
    public List<ScheduleDTO> getSchedules(
            @RequestParam(value = "start", required = false) String start,
            @RequestParam(value = "end", required = false) String end) {

        if (start != null && end != null) {
            LocalDateTime startTime = LocalDateTime.parse(start, DateTimeFormatter.ISO_DATE_TIME);
            LocalDateTime endTime = LocalDateTime.parse(end, DateTimeFormatter.ISO_DATE_TIME);
            return scheduleService.findByStartTimeBetween(startTime, endTime).stream()
                    .map(scheduleMapper::toDTO)
                    .collect(Collectors.toList());
        } else {
            return scheduleService.findAll().stream()
                    .map(scheduleMapper::toDTO)
                    .collect(Collectors.toList());
        }
    }

    // Altri endpoint per create, update e delete
}
