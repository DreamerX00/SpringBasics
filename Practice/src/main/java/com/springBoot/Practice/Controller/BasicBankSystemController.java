package com.springBoot.Practice.Controller;

import com.springBoot.Practice.Entity.BasicBankSystem;
import com.springBoot.Practice.Entity.BasicBankUsers;
import com.springBoot.Practice.Service.BasicBankSystemService;
import com.springBoot.Practice.Service.BasicBankUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/basicBank")
public class BasicBankSystemController {
    private final BasicBankUserService basicBankUserService;
    BasicBankSystemService basicBankSystemService;

    public BasicBankSystemController(BasicBankSystemService basicBankSystemService, BasicBankUserService basicBankUserService) {
        this.basicBankSystemService = basicBankSystemService;
        this.basicBankUserService = basicBankUserService;
    }

    @GetMapping("/accessAccount/{accountNumber}/{password}")
    public ResponseEntity<BasicBankSystem> accessAccount(@PathVariable String accountNumber, @PathVariable String password) {
        if (basicBankSystemService.accountVerification(accountNumber, password)) {
            BasicBankSystem account = basicBankSystemService.getAccountByAccountNumber(accountNumber);
            return new ResponseEntity<>(account, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);// Unauthorized
        }
    }

    @GetMapping("/accessAccountBalance/{accountNumber}/{password}")
    public ResponseEntity<Double> accessAccountBalance(@PathVariable String accountNumber, @PathVariable String password) {
        if (basicBankSystemService.accountVerification(accountNumber, password)) {
            BasicBankSystem account = basicBankSystemService.getAccountByAccountNumber(accountNumber);
            BasicBankUsers basicBankUsers = account.getUsers();
            if (basicBankUsers != null) {
                double balance = basicBankUsers.getBalance();
                return new ResponseEntity<>(balance, HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // User not found
            }
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);// Unauthorized
        }
    }

    @PostMapping("/createAccount/{userId}")
    public ResponseEntity<String> createAccount(@RequestBody BasicBankSystem basicBankSystem, @PathVariable String userId) {
        BasicBankUsers user = basicBankUserService.getUserByUserId(userId);
        if (user == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        } else {
            try {
                basicBankSystem.setUsers(user);
                basicBankSystemService.createAccount(basicBankSystem);
                return new ResponseEntity<>("Account created successfully", HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>("Error creating account: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }


    @PutMapping("/updateAccount/{accountNumber}/{password}")
    @Transactional
    public ResponseEntity<String> updateAccount(@RequestBody BasicBankSystem basicBankSystem, @PathVariable String accountNumber, @PathVariable String password) {
        if (!basicBankSystemService.accountVerification(accountNumber, password)) {
            return new ResponseEntity<>("Account not found or invalid credentials", HttpStatus.NOT_FOUND);
        } else {
            try {
                basicBankSystemService.updateAccount(basicBankSystem);
                return new ResponseEntity<>("Account updated successfully", HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>("Error updating account: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @PutMapping("/withdraw/{accountNumber}/{password}/{amount}")
    @Transactional
    public ResponseEntity<String> withdraw(@PathVariable String accountNumber, @PathVariable String password, @PathVariable double amount) {
        if (!basicBankSystemService.accountVerification(accountNumber, password)) {
            return new ResponseEntity<>("Account not found or invalid credentials", HttpStatus.NOT_FOUND);
        } else {
            try {
                BasicBankSystem account = basicBankSystemService.getAccountByAccountNumber(accountNumber);
                BasicBankUsers user = account.getUsers();
                if (user != null) {
                    if (user.getBalance() >= amount) {
                        user.setBalance(user.getBalance() - amount);
                        basicBankUserService.updateUser(user);
                        return new ResponseEntity<>("Withdrawal successful", HttpStatus.OK);
                    } else {
                        return new ResponseEntity<>("Insufficient balance", HttpStatus.BAD_REQUEST);
                    }
                }
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            } catch (Exception e) {
                return new ResponseEntity<>("Error during withdrawal: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @PutMapping("/deposit/{accountNumber}/{password}/{amount}")
    @Transactional
    public ResponseEntity<String> deposit(@PathVariable String accountNumber, @PathVariable String password, @PathVariable double amount) {
        if (!basicBankSystemService.accountVerification(accountNumber, password)) {
            return new ResponseEntity<>("Account not found or invalid credentials", HttpStatus.NOT_FOUND);
        } else {
            try {
                BasicBankSystem account = basicBankSystemService.getAccountByAccountNumber(accountNumber);
                BasicBankUsers user = account.getUsers();
                if (user != null) {
                    user.setBalance(user.getBalance() + amount);
                    basicBankUserService.updateUser(user);
                    return new ResponseEntity<>("Deposit successful", HttpStatus.OK);
                }
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            } catch (Exception e) {
                return new ResponseEntity<>("Error during deposit: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/deleteAccount/{accountNumber}/{password}")
    public ResponseEntity<String> deleteAccount(@PathVariable String accountNumber, @PathVariable String password) {
        if (!basicBankSystemService.accountVerification(accountNumber, password)) {
            return new ResponseEntity<>("Account not found or invalid credentials", HttpStatus.NOT_FOUND);
        } else {
            try {
                basicBankSystemService.deleteAccount(accountNumber);
                return new ResponseEntity<>("Account deleted successfully", HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>("Error deleting account: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }


}
