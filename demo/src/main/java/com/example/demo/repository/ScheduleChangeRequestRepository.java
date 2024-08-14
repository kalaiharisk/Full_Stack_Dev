package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ScheduleChangeRequest;

@Repository
public interface ScheduleChangeRequestRepository extends JpaRepository<ScheduleChangeRequest, Long> {
}
