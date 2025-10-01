package com.springBoot.Practice.Controller;

import com.springBoot.Practice.Entity.UserTasks;
import com.springBoot.Practice.Service.UserTasksService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userTasks")
public class UserTasksController {

    private final UserTasksService userTasksService;

    @Autowired
    public UserTasksController(UserTasksService userTasksService) {
        this.userTasksService = userTasksService;
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<UserTasks>> getById(@PathVariable ObjectId id){
        Optional<UserTasks> optionalUserTasks = userTasksService.getEntryById(id);
        if (optionalUserTasks.isPresent()) return new ResponseEntity<>(optionalUserTasks, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Optional<List<UserTasks>>> getAll(){
        Optional<List<UserTasks>> optionalUserTasksList = userTasksService.getAllEntry();
        if (optionalUserTasksList.isPresent()) return new ResponseEntity<>(optionalUserTasksList, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getByUserName/{user}")
    public ResponseEntity<UserTasks> getByUserName(@PathVariable String user){
        UserTasks userTasks = userTasksService.findByUsername(user);
        if (userTasks != null) return new ResponseEntity<>(userTasks, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getByPhoneNumber/{phoneNumber}")
    public ResponseEntity<UserTasks> getByPhoneNumber(@PathVariable String phoneNumber){
        UserTasks userTasks = userTasksService.findByPhoneNumber(phoneNumber);
        if (userTasks != null) return new ResponseEntity<>(userTasks, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/put")
    public ResponseEntity<String> add(@RequestBody UserTasks userTasks){
        try{
            userTasksService.saveEntry(userTasks);
            return new ResponseEntity<>("Data Inserted Successfully ",HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/putAll")
    public ResponseEntity<String> addAll(@RequestBody List<UserTasks> userTasks){
        try{
            userTasksService.saveAllEntry(userTasks);
            return new ResponseEntity<>("Multiple Data Inserted Successfully ",HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateByUserName/{user}")
    public ResponseEntity<String> updateByUserName(@RequestBody UserTasks userTasks,@PathVariable String user){
       UserTasks NumberInDb = userTasksService.findByUsername(user);
       if (NumberInDb != null){
           NumberInDb.setUserName(userTasks.getUserName());
           NumberInDb.setPass(userTasks.getPass());
           userTasksService.saveEntry(NumberInDb);
           return new ResponseEntity<>("Entry Updated",HttpStatus.OK);
       }
       return new ResponseEntity<>("Not Updated",HttpStatus.BAD_REQUEST);
    }
    @PutMapping("/updateByNumber/{phoneNumber}")
    public ResponseEntity<String> updateByNumber(@RequestBody UserTasks userTasks,@PathVariable String phoneNumber){
       UserTasks userInDb = userTasksService.findByPhoneNumber(phoneNumber);
       if (userInDb != null){
           userInDb.setUserName(userTasks.getUserName());
           userInDb.setPass(userTasks.getPass());
           userInDb.setAge(userTasks.getAge());
           userInDb.setPhoneNumber(userTasks.getPhoneNumber());

           userTasksService.saveEntry(userInDb);
           return new ResponseEntity<>("Entry Updated",HttpStatus.OK);
       }
       else {
           return new ResponseEntity<>("User with this phone number not found",HttpStatus.NOT_FOUND);
       }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable ObjectId id){
        try{
            userTasksService.deleteEntryById(id);
            return new ResponseEntity<>("Data Deleted Successfully",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAll(){
        try{
            userTasksService.deleteAllEntry();
            return new ResponseEntity<>("All Data Deleted",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
