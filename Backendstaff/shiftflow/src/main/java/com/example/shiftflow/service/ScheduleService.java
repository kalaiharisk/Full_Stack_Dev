package com.example.shiftflow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shiftflow.model.Schedule;
import com.example.shiftflow.repo.ScheduleRepository;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }
}
