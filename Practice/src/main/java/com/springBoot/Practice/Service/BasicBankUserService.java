package com.springBoot.Practice.Service;

import com.springBoot.Practice.Entity.BasicBankUsers;
import com.springBoot.Practice.Repository.BasicBankUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicBankUserService {
    private final BasicBankUserRepository basicBankUserRepository;

    public BasicBankUserService(BasicBankUserRepository basicBankUserRepository) {
        this.basicBankUserRepository = basicBankUserRepository;
    }

    public void createUser(BasicBankUsers users){
        basicBankUserRepository.save(users);
    }

    public void createMultipleUsers(List<BasicBankUsers> usersList){
        basicBankUserRepository.saveAll(usersList);
    }

    public BasicBankUsers getUserByUserId(String userId){
        return basicBankUserRepository.findBasicBankUsersByUserId(userId);
    }

    public void updateUser(BasicBankUsers users){
        basicBankUserRepository.save(users);
    }

    public void deleteUser(String userId){
        basicBankUserRepository.deleteBasicBankUsersByUserId(userId);
    }

    public double getUserBalance(String userId){
        BasicBankUsers user = getUserByUserId(userId);
        return user != null ? user.getBalance() : 0.0;
    }

    public void updateUserBalance(String userId, double amount){
        BasicBankUsers user = getUserByUserId(userId);
        if(user != null){
            user.setBalance(user.getBalance() + amount);
            basicBankUserRepository.save(user);
        } else {
            System.out.println("User not found.");
        }
    }

    public List<BasicBankUsers> getAllUsers(){
        return basicBankUserRepository.findAll();
    }


    public BasicBankUsers getUserByEmail(String emailId) {
        return basicBankUserRepository.findBasicBankUsersByEmail(emailId);
    }
}
