package com.libraryrest.demo.service;

import java.util.ArrayList;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.libraryrest.demo.dao.UsersDao;

import com.libraryrest.demo.model.Users;

 

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UsersDao udao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
    	Users user=udao.findByUserName(username);
    	if (user!=null) {
            return new User(user.getUserName(),user.getPassword(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
