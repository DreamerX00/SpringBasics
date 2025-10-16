package com.springBoot.Practice.Entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@NoArgsConstructor
public class BasicBankUsers {
    @Id
    private ObjectId id;
    @NonNull
    private String userId;
    @NonNull
    private String name;
    private String email;
    @NonNull
    private String phoneNumber;
    private double balance = 0.0;
    private List<String> roles;
}
