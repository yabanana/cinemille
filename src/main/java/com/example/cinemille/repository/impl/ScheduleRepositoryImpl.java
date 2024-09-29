package com.example.cinemille.repository.impl;

import com.example.cinemille.model.Schedule;
import com.example.cinemille.repository.ScheduleRepository;
import com.example.cinemille.repository.jpa.ScheduleJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class ScheduleRepositoryImpl implements ScheduleRepository {

    private final ScheduleJpaRepository scheduleJpaRepository;

    @Autowired
    public ScheduleRepositoryImpl(ScheduleJpaRepository scheduleJpaRepository) {
        this.scheduleJpaRepository = scheduleJpaRepository;
    }

    @Override
    public List<Schedule> findAll() {
        return scheduleJpaRepository.findAll();
    }

    @Override
    public Optional<Schedule> findById(Long id) {
        return scheduleJpaRepository.findById(id);
    }

    @Override
    public Schedule save(Schedule entity) {
        return scheduleJpaRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        scheduleJpaRepository.deleteById(id);
    }

    @Override
    public List<Schedule> findByStartTimeBetween(LocalDateTime start, LocalDateTime end) {
        return scheduleJpaRepository.findByStartTimeBetween(start, end);
    }
}
