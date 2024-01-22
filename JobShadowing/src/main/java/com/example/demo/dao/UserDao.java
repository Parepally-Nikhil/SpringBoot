package com.example.demo.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.example.demo.model.JobShadowRequest;
import com.example.demo.model.User;

@Component
public class UserDao {
	
	ArrayList<User> users=new ArrayList<User>();
	ArrayList<JobShadowRequest> jobRequests=new ArrayList<JobShadowRequest>();
	
	
	public ArrayList<JobShadowRequest> getJobRequests() {
		return jobRequests;
	}

	public boolean addUser(User user) {
	
		if(users.add(user)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public User getUser(String uemailId) {
		for(int i=0;i<users.size();i++) {
			if((users.get(i).getUemailId()).equals(uemailId)) {
				return users.get(i);
			}
		}
		return null;
	}

	public boolean storeRequestData(JobShadowRequest jsr) {
		if(jobRequests.add(jsr)) {
			return true;
		}
		return false;
	}
	
}
