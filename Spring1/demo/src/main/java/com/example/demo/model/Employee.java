package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String role;
    private String image;

    // @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    // private List<Schedule> schedules = new ArrayList<>();

    public Employee() {
    }

    public Employee(Long id, String name, String role, String image) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.image = image;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    // public List<Schedule> getSchedules() {
    //     return schedules;
    // }

    // public void setSchedules(List<Schedule> schedules) {
    //     this.schedules = schedules;
    // }

    // // Helper methods
    // public void addSchedule(Schedule schedule) {
    //     schedules.add(schedule);
    //     schedule.setEmployee(this);
    // }

    // public void removeSchedule(Schedule schedule) {
    //     schedules.remove(schedule);
    //     schedule.setEmployee(null);
    // }
}
