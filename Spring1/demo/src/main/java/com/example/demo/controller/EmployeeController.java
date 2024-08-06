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

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
        if (updatedEmployee != null) {
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


// import java.util.List;
// import java.util.Optional;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.model.Employee;
// import com.example.demo.service.EmployeeService;

// @RestController
// @RequestMapping("/api/employees")
// public class EmployeeController {

//      private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

//     @Autowired
//     private EmployeeService employeeService;

//     @PostMapping
//     public Employee createEmployee(@RequestBody Employee employee) {
//         logger.info("Creating employee: {}", employee);
//         return employeeService.saveEmployee(employee);
//     }

//     @GetMapping
//     public List<Employee> getAllEmployees() {
//         return employeeService.getAllEmployees();
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
//         Optional<Employee> employee = employeeService.getEmployeeById(id);
//         return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//     }
//     @PutMapping("/{id}")
//     public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
//         if (!employeeService.getEmployeeById(id).isPresent()) {
//             return ResponseEntity.notFound().build();
//         }
//         employee.setId(id);
//         return ResponseEntity.ok(employeeService.saveEmployee(employee));
//     }

//     @DeleteMapping("/{id}")
//     public void deleteEmployee(@PathVariable Long id) {
//         employeeService.deleteEmployee(id);
//     }
// }
