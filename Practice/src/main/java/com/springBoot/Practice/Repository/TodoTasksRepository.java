package com.springBoot.Practice.Repository;

import com.springBoot.Practice.Entity.TodoTasks;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TodoTasksRepository extends MongoRepository<TodoTasks, ObjectId> {


    Optional<TodoTasks> findTodoTasksByTaskName(String taskName);
}
