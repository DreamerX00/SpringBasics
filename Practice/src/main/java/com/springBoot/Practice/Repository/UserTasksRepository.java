package com.springBoot.Practice.Repository;

import com.springBoot.Practice.Entity.UserTasks;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserTasksRepository extends MongoRepository<UserTasks, ObjectId> {

    UserTasks findByUserName(String userName);

    UserTasks findByPhoneNumber(String phoneNumber);

}
