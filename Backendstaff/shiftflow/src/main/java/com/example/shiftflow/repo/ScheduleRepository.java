package com.example.shiftflow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shiftflow.model.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
