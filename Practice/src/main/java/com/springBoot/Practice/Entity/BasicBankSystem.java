package com.springBoot.Practice.Entity;

import com.springBoot.Practice.Enum.BasicBankAccountType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
@NoArgsConstructor
public class BasicBankSystem {
    @Id
    private ObjectId id;
    private String accountNumber;
    @DBRef
    private BasicBankUsers users;
    private String password;
    private BasicBankAccountType accountType;
    private Date createdAt;
    private Date updatedAt;
}
