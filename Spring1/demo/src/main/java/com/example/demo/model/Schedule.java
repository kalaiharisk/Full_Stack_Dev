package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String timing;
    private String shift;
    private String task;
    

    @ManyToOne
    //@JoinColumn(name = "employee_id")
    private Employee employee;

    public Schedule() {
    }

    public Schedule(Long id, String timing, String shift, Employee employee,String task) {
        this.id = id;
        this.timing = timing;
        this.shift = shift;
        this.employee = employee;
        this.task=task;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String gettiming() {
        return timing;
    }

    public void settiming(String timing) {
        this.timing = timing;
    }

    public String getShift() {
        return shift;
    }

    public void setTask(String task) {
        this.task = task;
    }
    public String getTask() {
        return task;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
