package com.springBoot.Practice.Entity;


import com.springBoot.Practice.Enum.Department;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@Document
public class Employee {
    @Id
    private long id;
    @NonNull
    @Indexed(unique = true)
    private String username;
    @NonNull
    private String password;
    @NonNull
    private String name;
    private String email;
    @NonNull
    private Department department;
    private double salary;
    @NonNull
    private List<String> Roles;
}
