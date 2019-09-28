package com.example.student_manager.demo.service;

import com.example.student_manager.demo.entity.Account;
import com.example.student_manager.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountSerivce {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public Account create(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepository.save(account);
    }

    public Account getAccount(long id) {
        return accountRepository.findById(id).orElse(null);
    }

    public Account findByEmail(String email) {
        System.out.println("find email");
        if (email == null) System.out.println("email is null");
        else System.out.println("email is :"+ email);
        return accountRepository.findFirstByEmail(email).orElse(null);
    }
}
