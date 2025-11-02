package com.springBoot.Practice.Service;

import com.springBoot.Practice.Entity.Employee;
import com.springBoot.Practice.Repository.EmployeeRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class EmployeeService{
    private final EmployeeRepository employeeRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void saveNewEmployee(Employee employee){
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employee.setRoles(Arrays.asList("USER"));
        employeeRepository.save(employee);
    }

    public Employee getEmployeeByUsername(String username){
        return employeeRepository.findByUsername(username);
    }


}
