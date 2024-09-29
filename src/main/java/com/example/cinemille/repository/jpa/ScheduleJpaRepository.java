package com.example.cinemille.repository.jpa;

import com.example.cinemille.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScheduleJpaRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);
}
