package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Schedule;
import com.example.demo.service.ScheduleService;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping
    public List<Schedule> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable Long id) {
        Optional<Schedule> schedule = scheduleService.getScheduleById(id);
        return schedule.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Schedule> createSchedule(@RequestBody Schedule schedule) {
        return new ResponseEntity<>(scheduleService.saveSchedule(schedule), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable Long id, @RequestBody Schedule schedule) {
        Schedule updatedSchedule = scheduleService.updateSchedule(id, schedule);
        if (updatedSchedule != null) {
            return new ResponseEntity<>(updatedSchedule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.model.Schedule;
// import com.example.demo.service.ScheduleService;

// @RestController
// @RequestMapping("/api/schedules")
// public class ScheduleController {
//     @Autowired
//     private ScheduleService scheduleService;

//     @GetMapping
//     public List<Schedule> getAllSchedules() {
//         return scheduleService.getAllSchedules();
//     }

//     @PostMapping
//     public Schedule createSchedule(@RequestBody Schedule schedule) {
//         return scheduleService.saveSchedule(schedule);
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<Schedule> updateSchedule(@PathVariable Long id, @RequestBody Schedule schedule) {
//         Schedule updatedSchedule = scheduleService.updateSchedule(id, schedule);
//         if (updatedSchedule != null) {
//             return new ResponseEntity<>(updatedSchedule, HttpStatus.OK);
//         } else {
//             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//         }
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
//         scheduleService.deleteSchedule(id);
//         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//     }
// }


// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.model.Schedule;
// import com.example.demo.service.ScheduleService;

// @RestController
// @RequestMapping("/api/schedules")
// public class ScheduleController {
//     @Autowired
//     private ScheduleService scheduleService;

//     @GetMapping
//     public List<Schedule> getAllSchedules() {
//         return scheduleService.getAllSchedules();
//     }

//     @PostMapping
//     public Schedule createSchedule(@RequestBody Schedule schedule) {
//         return scheduleService.saveSchedule(schedule);
//     }
// }
