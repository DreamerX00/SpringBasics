package com.springBoot.Practice.Service;

import com.springBoot.Practice.Entity.UserTasks;
import com.springBoot.Practice.Repository.UserTasksRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserTasksService {

    private final UserTasksRepository userTasksRepository;

    public UserTasksService(UserTasksRepository userTasksRepository) {
        this.userTasksRepository = userTasksRepository;
    }

    //Saving Entries
    public void saveEntry(UserTasks userTasks){
        userTasksRepository.save(userTasks);
    }

    public void saveAllEntry(List<UserTasks> userTasks){
        userTasksRepository.saveAll(userTasks);
    }

    //Getting Entries
    public Optional<UserTasks> getEntryById(ObjectId id){
        return userTasksRepository.findById(id);
    }

    public Optional<List<UserTasks>> getAllEntry(){
        return Optional.of(userTasksRepository.findAll());
    }

    //Updating Entries
    public UserTasks findByUsername(String username){
        return userTasksRepository.findByUserName(username);
    }
    public UserTasks findByPhoneNumber(String phoneNumber){
        return userTasksRepository.findByPhoneNumber(phoneNumber);
    }

    //Deleting Entries
    public void deleteEntryById(ObjectId id){
        userTasksRepository.deleteById(id);
    }

    public void deleteAllEntry(){
        userTasksRepository.deleteAll();
    }

}
