package com.springBoot.Practice.Repository;

import com.springBoot.Practice.Entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Long> {

    Employee findByName(String name);

    Employee findByUsername(String username);
}
