package com.springBoot.Practice.Controller;

import com.springBoot.Practice.Entity.Employee;
import com.springBoot.Practice.Repository.EmployeeRepository;
import com.springBoot.Practice.Service.EmployeeService;
import org.springframework.boot.actuate.endpoint.SecurityContext;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/saveUser")
    public ResponseEntity<String> saveUser(@RequestBody Employee employee) {
        try {
            employeeService.saveNewEmployee(employee);
            return ResponseEntity.ok("Employee saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error saving employee: " + e.getMessage());
        }
    }

    @PutMapping("/updateUser")
    public ResponseEntity<String> updateUser(@RequestBody Employee employee) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Employee existingEmployee = employeeService.getEmployeeByUsername(username);
        employee.setId(existingEmployee.getId());
        try {
            employeeService.saveNewEmployee(employee);
            return ResponseEntity.ok("Employee updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error updating employee: " + e.getMessage());
        }
    }

    @GetMapping("/getUser")
    public ResponseEntity<Employee> getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Employee employee = employeeService.getEmployeeByUsername(username);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
