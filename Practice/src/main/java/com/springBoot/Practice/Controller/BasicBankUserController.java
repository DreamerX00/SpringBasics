package com.springBoot.Practice.Controller;

import com.springBoot.Practice.Entity.BasicBankUsers;
import com.springBoot.Practice.Service.BasicBankUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/basicBankUser")
public class BasicBankUserController {
    BasicBankUserService basicBankUserService;

    public BasicBankUserController(BasicBankUserService basicBankUserService) {
        this.basicBankUserService = basicBankUserService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<BasicBankUsers>> getAllUsers(){
        List<BasicBankUsers> users = basicBankUserService.getAllUsers();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<BasicBankUsers> getUserById(@PathVariable String userId) {
        BasicBankUsers user = basicBankUserService.getUserByUserId(userId);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/getUserByEmail/{emailId}")
    public ResponseEntity<BasicBankUsers> getUserByEmail(@PathVariable String emailId) {
        BasicBankUsers user = basicBankUserService.getUserByEmail(emailId);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/getUserBalance/{userId}")
    public ResponseEntity<Double> getUserBalance(@PathVariable String userId) {
        BasicBankUsers user = basicBankUserService.getUserByUserId(userId);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(basicBankUserService.getUserBalance(userId), HttpStatus.OK);
    }

    @PostMapping("/createUsers")
    public ResponseEntity<String> createUser(@RequestBody BasicBankUsers users){
        if (users.getEmail() == null) {
            return new ResponseEntity<>("User ID and Email are required", HttpStatus.BAD_REQUEST);
        }else if (basicBankUserService.getUserByEmail(users.getEmail()) != null && basicBankUserService.getUserByUserId(users.getUserId()) != null) {
            return new ResponseEntity<>("User with given Email or User ID already exists", HttpStatus.CONFLICT);
        }
        else {
            try {
            basicBankUserService.createUser(users);
            return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        }

    }

    @PostMapping("/createMultipleUsers")
    public ResponseEntity<String> createMultipleUsers(@RequestBody List<BasicBankUsers> usersList) {
        try {
            basicBankUserService.createMultipleUsers(usersList);
            return new ResponseEntity<>("Users created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating users: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<String> updateUser(@RequestBody BasicBankUsers users, @PathVariable String userId) {
        if (basicBankUserService.getUserByUserId(userId) == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        } else {
            try {
                basicBankUserService.updateUser(users);
                return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>("Error updating user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @PutMapping("/updateUserBalance/{userId}/{amount}")
    public ResponseEntity<String> updateUserBalance(@PathVariable String userId, @PathVariable double amount) {
        if (basicBankUserService.getUserByUserId(userId) == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        } else {
            try {
                basicBankUserService.updateUserBalance(userId, amount);
                return new ResponseEntity<>("User balance updated successfully", HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>("Error updating user balance: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) {
        if (basicBankUserService.getUserByUserId(userId) == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        } else {
            try {
                basicBankUserService.deleteUser(userId);
                return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>("Error deleting user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

}
