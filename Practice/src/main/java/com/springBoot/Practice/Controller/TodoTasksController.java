package com.springBoot.Practice.Controller;

import com.springBoot.Practice.Entity.TodoTasks;
import com.springBoot.Practice.Entity.UserTasks;
import com.springBoot.Practice.Service.TodoTasksService;
import com.springBoot.Practice.Service.UserTasksService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todoTasks")
public class TodoTasksController {
    private final TodoTasksService todoTasksService;
    private final UserTasksService userTasksService;

    public TodoTasksController(TodoTasksService todoTasksService, UserTasksService userTasksService) {
        this.todoTasksService = todoTasksService;
        this.userTasksService = userTasksService;
    }


    //Operations With User Specific
    @PostMapping("/putForUser/{user}")
    public ResponseEntity<String> addForUser(@RequestBody TodoTasks todoTasks, @PathVariable String user){
        try{
            todoTasksService.createTaskForUser(user, todoTasks);
            return new ResponseEntity<>("Data Inserted Successfully for user: "+user,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/putForUserByPhoneNumber/{phoneNumber}")
    public ResponseEntity<String> addForUserByPhoneNumber(@RequestBody TodoTasks todoTasks, @PathVariable String phoneNumber){
        try{
            todoTasksService.createTaskForUserByPhoneNumber(phoneNumber, todoTasks);
            return new ResponseEntity<>("Data Inserted Successfully for user with phone number: "+phoneNumber,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/putAllForUser/{user}")
    public ResponseEntity<String> addAllForUser(@RequestBody List<TodoTasks> todoTasks, @PathVariable String user){
        try{
            todoTasksService.createMultipleTasksForUser(user, todoTasks);
            return new ResponseEntity<>("Multiple Data Inserted Successfully for user: "+user,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllTasksForUser/{user}")
    public ResponseEntity<List<TodoTasks>> getAllTasksForUser(@PathVariable String user )
    {
        List<TodoTasks> allTasksForUser = todoTasksService.getAllTasksForUser(user);
        if (allTasksForUser != null) return ResponseEntity.ok(allTasksForUser);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAllTasksForUserByPhoneNumber/{phoneNumber}")
    public ResponseEntity<List<TodoTasks>> getAllTasksForUserByPhoneNumber(@PathVariable String phoneNumber){
        List<TodoTasks> allTasksForUserByPhoneNumber = todoTasksService.getAllTasksForUserByPhoneNumber(phoneNumber);
        if (allTasksForUserByPhoneNumber != null) return ResponseEntity.ok(allTasksForUserByPhoneNumber);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteForUserById/{user}/{id}")
    public ResponseEntity<String> deleteForUserById(@PathVariable String user, @PathVariable ObjectId id){
        try{
            todoTasksService.deleteTaskForUserById(user, id);
            return new ResponseEntity<>("Data Deleted Successfully for user: "+user,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    // Normal Operations Without User Specific
    @GetMapping("/getAllTasks")
    public ResponseEntity<Optional<List<TodoTasks>>> getAllTasks(){
        Optional<List<TodoTasks>> allTasks = todoTasksService.getAllTasks();
        if (allTasks.isPresent()) return ResponseEntity.ok(allTasks);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<String> getById(@PathVariable ObjectId id){
        Optional<TodoTasks> taskById = todoTasksService.getTaskById(id);
        if (taskById.isPresent()) return ResponseEntity.ok(taskById.toString());
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getByName/{taskName}")
    public ResponseEntity<String> getByName(@PathVariable String taskName) {
        Optional<TodoTasks> taskByName = todoTasksService.getTaskByName(taskName);
        if (taskByName.isPresent()) return ResponseEntity.ok(taskByName.toString());
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/put")
    public ResponseEntity<String> add(@RequestBody TodoTasks todoTasks){
        try{
            todoTasksService.createTask(todoTasks);
            return new ResponseEntity<>("Data Inserted Successfully ",HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/putAll")
    public ResponseEntity<String> addAll(@RequestBody List<TodoTasks> todoTasks){
        try{
            todoTasksService.createMultipleTasks(todoTasks);
            return new ResponseEntity<>("Multiple Data Inserted Successfully ",HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<String> updateById(@RequestBody TodoTasks todoTasks,@PathVariable ObjectId id) {
        try {
            todoTasksService.updateTaskById(id, todoTasks);
            return new ResponseEntity<>("Data Updated Successfully ", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateByName/{taskName}")
    public ResponseEntity<String> updateByName(@PathVariable String taskName) {
        try {
            todoTasksService.updateTaskByName(taskName);
            return new ResponseEntity<>("Data Updated Successfully ", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable ObjectId id){
        try{
            todoTasksService.deleteTaskById(id);
            return new ResponseEntity<>("Data Deleted Successfully ",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAll(){
        try{
            todoTasksService.deleteAllTasks();
            return new ResponseEntity<>("All Data Deleted Successfully ",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


}
