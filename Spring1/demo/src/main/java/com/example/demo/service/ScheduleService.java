package com.example.demo.service;


// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.model.Schedule;
// import com.example.demo.repository.ScheduleRepository;

// @Service
// public class ScheduleService {
//     @Autowired
//     private ScheduleRepository scheduleRepository;

//     public List<Schedule> getAllSchedules() {
//         return scheduleRepository.findAll();
//     }

//     public Schedule saveSchedule(Schedule schedule) {
//         return scheduleRepository.save(schedule);
//     }
// }


// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.model.Schedule;
// import com.example.demo.repository.ScheduleRepository;

// @Service
// public class ScheduleService {
//     @Autowired
//     private ScheduleRepository scheduleRepository;

//     public List<Schedule> getAllSchedules() {
//         return scheduleRepository.findAll();
//     }

//     public Schedule saveSchedule(Schedule schedule) {
//         return scheduleRepository.save(schedule);
//     }

//     public Optional<Schedule> getScheduleById(Long id) {
//         return scheduleRepository.findById(id);
//     }

//     public Schedule updateSchedule(Long id, Schedule schedule) {
//         if (scheduleRepository.existsById(id)) {
//             schedule.setId(id);
//             return scheduleRepository.save(schedule);
//         } else {
//             return null; // or throw an exception if you prefer
//         }
//     }

//     public void deleteSchedule(Long id) {
//         scheduleRepository.deleteById(id);
//     }
// }


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Schedule;
import com.example.demo.repository.ScheduleRepository;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public Optional<Schedule> getScheduleById(Long id) {
        return scheduleRepository.findById(id);
    }

    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public Schedule updateSchedule(Long id, Schedule schedule) {
        if (scheduleRepository.existsById(id)) {
            schedule.setId(id);
            return scheduleRepository.save(schedule);
        } else {
            return null; // or throw an exception
        }
    }

    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }
}
