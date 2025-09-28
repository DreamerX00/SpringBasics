package com.springBoot.Practice.Entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "journalEntry")
@Data
public class JournalEntryV2{
    @Id
    private ObjectId _id;
    private int id;
    private String title;
    private String content;

}
