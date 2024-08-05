package com.example.shiftflow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shiftflow.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
