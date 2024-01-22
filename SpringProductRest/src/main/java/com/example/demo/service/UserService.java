package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepo;
import com.example.demo.model.User;

@Service
public class UserService {
    @Autowired
    private UserRepo ur;
    
    public User createUser(User user) {
        return ur.save(user);
    }
}
