package com.springBoot.Practice.Service;

import com.springBoot.Practice.Entity.BasicBankSystem;
import com.springBoot.Practice.Enum.BasicBankAccountType;
import com.springBoot.Practice.Repository.BasicBankSystemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicBankSystemService {

    private final BasicBankSystemRepository basicBankSystemRepository;

    public BasicBankSystemService(BasicBankSystemRepository basicBankSystemRepository) {
        this.basicBankSystemRepository = basicBankSystemRepository;
    }

    public void createAccount(BasicBankSystem basicBankSystem) {
        basicBankSystemRepository.save(basicBankSystem);
    }

    public boolean accountVerification(String accountNumber, String password) {
        return basicBankSystemRepository.findAll()
                .stream()
                .anyMatch(acc -> acc.getAccountNumber().equals(accountNumber) && acc.getPassword().equals(password));
    }

    public void updateAccount(BasicBankSystem basicBankSystem) {
        basicBankSystemRepository.save(basicBankSystem);
    }

    public void deleteAccount(String accountNumber) {
        basicBankSystemRepository.findAll()
                .stream()
                .filter(acc -> acc.getAccountNumber().equals(accountNumber))
                .findFirst().ifPresent(basicBankSystemRepository::delete);
    }

    public BasicBankSystem getAccountByAccountNumber(String accountNumber) {
        return basicBankSystemRepository.findAll()
                .stream()
                .filter(acc -> acc.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElse(null);
    }

    public void getAccountType(String accountNumber) {      
        BasicBankSystem account = getAccountByAccountNumber(accountNumber);
        if (account != null) {
            System.out.println("Account Type: " + account.getAccountType());
        } else {
            System.out.println("Account not found.");
        }
    }

    public List<BasicBankSystem> getAllAccounts() {
        return basicBankSystemRepository.findAll();
    }

    public List<BasicBankAccountType> getAllAccountTypes() {
        return List.of(BasicBankAccountType.values());
    }



}
