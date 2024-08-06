package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        if (employeeRepository.existsById(id)) {
            employee.setId(id);
            return employeeRepository.save(employee);
        } else {
            return null; // or throw an exception
        }
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}

// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.model.Employee;
// import com.example.demo.repository.EmployeeRepository;

// import jakarta.transaction.Transactional;

// @Service
// public class EmployeeService {
//     @Autowired
//     private final EmployeeRepository employeeRepository;
    
//     public EmployeeService(EmployeeRepository employeeRepository) {
//         this.employeeRepository = employeeRepository;
//     }

//     @Transactional
//     public Employee saveEmployee(Employee employee) {
//         return employeeRepository.save(employee);
//     }
//     public List<Employee> getAllEmployees() {
//         return employeeRepository.findAll();
//     }
//     public Optional<Employee> getEmployeeById(Long id) {
//         return employeeRepository.findById(id);
//     }

    

    // public Employee saveEmployee(Employee employee) {
    //     return employeeRepository.save(employee);
    // }

//     public void deleteEmployee(Long id) {
//         employeeRepository.deleteById(id);
//     }
// }
