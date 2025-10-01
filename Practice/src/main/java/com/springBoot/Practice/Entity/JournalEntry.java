package com.springBoot.Practice.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
public class JournalEntry {
    @Id
    private long id;
    private String title;
    private String content;
}
