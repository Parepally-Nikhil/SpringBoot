package com.example.demo.service;

//import java.util.ArrayList;
//
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//


//@Service
//public class MyUserDetailsService implements UserDetailsService {
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return new User("Nikhil","7799443721",new ArrayList<>());
//    }
//}


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import com.example.demo.model.UserPrincipal;

 

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        User user=repo.findByUsername(username);
        if(user==null)
            throw new UsernameNotFoundException("user 404");
        return new UserPrincipal(user);
    }

 


}