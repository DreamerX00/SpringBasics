package com.springBoot.Practice.Service;

import com.springBoot.Practice.Entity.TodoTasks;
import com.springBoot.Practice.Entity.UserTasks;
import com.springBoot.Practice.Repository.TodoTasksRepository;
import com.springBoot.Practice.Repository.UserTasksRepository;
import java.util.Collections;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class TodoTasksService {

    private final TodoTasksRepository todoTasksRepository;
    private final UserTasksService userTasksService;

    @Autowired
    public TodoTasksService(TodoTasksRepository todoTasksRepository, UserTasksService userTasksService) {
        this.todoTasksRepository = todoTasksRepository;
        this.userTasksService = userTasksService;
    }


    //User Specific Operations
    @Transactional
    public void createTaskForUser(String user, TodoTasks todoTasks){
        UserTasks userTasks = userTasksService.findByUsername(user);
        if (userTasks != null) {
            todoTasksRepository.save(todoTasks);
            List<TodoTasks> userTaskList = userTasks.getTasks();
            userTaskList.add(todoTasks);
            userTasks.setTasks(userTaskList);
            userTasksService.saveEntry(userTasks);
        }
    }

    @Transactional
    public void createMultipleTasksForUser(String user, List<TodoTasks> todoTasks){
        UserTasks userTasks = userTasksService.findByUsername(user);
        if (userTasks != null) {
            todoTasksRepository.saveAll(todoTasks);
            List<TodoTasks> userTaskList = userTasks.getTasks();
            userTaskList.addAll(todoTasks);
            userTasks.setTasks(userTaskList);
            userTasksService.saveEntry(userTasks);
        }
    }

    @Transactional
    public void createTaskForUserByPhoneNumber(String phoneNumber, TodoTasks todoTasks){
        UserTasks userTasks = userTasksService.findByPhoneNumber(phoneNumber);
        if (userTasks != null) {
            todoTasksRepository.save(todoTasks);
            List<TodoTasks> userTaskList = userTasks.getTasks();
            userTaskList.add(todoTasks);
            userTasks.setTasks(userTaskList);
            userTasksService.saveEntry(userTasks);
        }
    }

    public List<TodoTasks> getAllTasksForUser(String user){
        UserTasks userTasks = userTasksService.findByUsername(user);
        if (userTasks != null) {
            return userTasks.getTasks();
        } else {
            return Collections.emptyList();
        }
    }

    public List<TodoTasks> getAllTasksForUserByPhoneNumber(String phoneNumber){
        UserTasks userTasks = userTasksService.findByPhoneNumber(phoneNumber);
        if (userTasks != null) {
            return userTasks.getTasks();
        } else {
            return Collections.emptyList();
        }
    }

    @Transactional
    public void deleteTaskForUserById(String user, ObjectId id){
        UserTasks userTasks = userTasksService.findByUsername(user);
        if (userTasks != null) {
            List<TodoTasks> userTaskList = userTasks.getTasks();
            userTaskList.removeIf(task -> task.getId().equals(id));
            userTasks.setTasks(userTaskList);
            userTasksService.saveEntry(userTasks);
            todoTasksRepository.deleteById(id);
        }
    }





    //Non User Specific Operations

    public void createTask(TodoTasks todoTasks) {
        todoTasksRepository.save(todoTasks);
    }

    public void createMultipleTasks(List<TodoTasks> todoTasks){
        todoTasksRepository.saveAll(todoTasks);
    }

    public Optional<TodoTasks> getTaskById(ObjectId id) {
        return todoTasksRepository.findById(id);
    }

    public Optional<List<TodoTasks>> getAllTasks() {
        return Optional.of(todoTasksRepository.findAll());
    }

    public Optional<TodoTasks> getTaskByName(String taskName){
        return todoTasksRepository.findTodoTasksByTaskName(taskName);
    }

    public void deleteTaskById(ObjectId id) {
        todoTasksRepository.deleteById(id);
    }

    public void deleteAllTasks() {
        todoTasksRepository.deleteAll();
    }

    public void updateTaskById(ObjectId id, TodoTasks todoTasks) {
        Optional<TodoTasks> existingTask = todoTasksRepository.findById(id);
        if (existingTask.isPresent()) {
            TodoTasks taskToUpdate = existingTask.get();
            taskToUpdate.setTaskName(todoTasks.getTaskName());
            taskToUpdate.setDate(todoTasks.getDate());
            taskToUpdate.setTaskStatus(todoTasks.getTaskStatus());
            taskToUpdate.setTaskPriority(todoTasks.getTaskPriority());
            taskToUpdate.setTaskDescription(todoTasks.getTaskDescription());
            todoTasksRepository.save(taskToUpdate);
        }
    }

    public void updateTaskByName(String taskName){
        Optional<TodoTasks> existingTask = todoTasksRepository.findTodoTasksByTaskName(taskName);
        if(existingTask.isPresent()) {
            TodoTasks taskToUpdate = existingTask.get();
            taskToUpdate.setTaskStatus(com.springBoot.Practice.Enum.TaskStatus.COMPLETED);
            todoTasksRepository.save(taskToUpdate);
        }
    }


}
