package com.example.shiftflow.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shiftflow.model.Schedule;
import com.example.shiftflow.service.ScheduleService;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping
    public List<Schedule> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    @PostMapping
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        return scheduleService.saveSchedule(schedule);
    }
}
