package com.springBoot.Practice.Service;

import com.springBoot.Practice.Entity.Employee;
import com.springBoot.Practice.Repository.EmployeeRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDetailService implements UserDetailsService {

    private EmployeeRepository employeeRepository;

    public EmployeeDetailService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByUsername(username);
        if (employee == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return User.withUsername(employee.getUsername())
                .password(employee.getPassword())
                .roles(employee.getRoles().toArray(new String[0]))
                .build();
    }
}
