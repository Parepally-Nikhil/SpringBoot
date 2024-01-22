package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

 

import com.example.demo.dao.UserRepo;
import com.example.demo.model.User;

 

@Service
public class MyUserDetailsService implements UserDetailsService {

 

    @Autowired
    private UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        User user=repo.findByUsername(username);
        if(user==null)
            throw new UsernameNotFoundException("user 404");
        return new UserPrincipal(user);
    }

 


}