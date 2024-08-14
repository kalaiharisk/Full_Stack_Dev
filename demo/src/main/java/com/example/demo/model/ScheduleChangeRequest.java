package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ScheduleChangeRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String staffName;
    private String currentTask;
    private LocalDate desiredStartDate;
    private LocalDate desiredEndDate;
    private String reason;
    private String additionalComments;
    private String status;  // Add this field

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getCurrentTask() {
        return currentTask;
    }

    public void setCurrentTask(String currentTask) {
        this.currentTask = currentTask;
    }

    public LocalDate getDesiredStartDate() {
        return desiredStartDate;
    }

    public void setDesiredStartDate(LocalDate desiredStartDate) {
        this.desiredStartDate = desiredStartDate;
    }

    public LocalDate getDesiredEndDate() {
        return desiredEndDate;
    }

    public void setDesiredEndDate(LocalDate desiredEndDate) {
        this.desiredEndDate = desiredEndDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAdditionalComments() {
        return additionalComments;
    }

    public void setAdditionalComments(String additionalComments) {
        this.additionalComments = additionalComments;
    }

    public String getStatus() {  // Add this getter
        return status;
    }

    public void setStatus(String status) {  // Add this setter
        this.status = status;
    }

    public ScheduleChangeRequest() {
    }

    public ScheduleChangeRequest(Long id, String staffName, String currentTask, LocalDate desiredStartDate,
            LocalDate desiredEndDate, String reason, String additionalComments, String status) {
        this.id = id;
        this.staffName = staffName;
        this.currentTask = currentTask;
        this.desiredStartDate = desiredStartDate;
        this.desiredEndDate = desiredEndDate;
        this.reason = reason;
        this.additionalComments = additionalComments;
        this.status = status;  // Initialize this field in the constructor
    }
}
