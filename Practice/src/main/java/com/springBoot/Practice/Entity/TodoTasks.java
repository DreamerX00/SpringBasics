package com.springBoot.Practice.Entity;


import com.springBoot.Practice.Enum.TaskPriority;
import com.springBoot.Practice.Enum.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
@NoArgsConstructor
public class TodoTasks {
    @Id
    private ObjectId id;
    private String taskName;
    private Date date;
    private TaskStatus taskStatus;
    private TaskPriority taskPriority;
    private String taskDescription;
}
