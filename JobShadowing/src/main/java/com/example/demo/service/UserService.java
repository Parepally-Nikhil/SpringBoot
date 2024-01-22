package com.example.demo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProfessionalDao;
import com.example.demo.dao.UserDao;
import com.example.demo.model.JobShadowPost;
import com.example.demo.model.JobShadowRequest;
import com.example.demo.model.User;

@Service
public class UserService {
	@Autowired
	private UserDao udao;
	
	@Autowired
	private ProfessionalDao pdao;
	
	static int useq=0;
	static int rseq=0;
	public boolean userSignUp(User user) {
		useq++;
		user.setUid("user_"+useq);
		if(udao.addUser(user)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean userLogin(User user) {
		User u=udao.getUser(user.getUemailId());
		if(u!=null) {
			if(user.getUpassword().equals(u.getUpassword())) {
				return true;
			}
		}
		return false;
	}

	public boolean storeJobShadowRequest(HttpServletRequest request, JobShadowRequest jsr) {
		rseq++;
		jsr.setRid("req_"+rseq);
		String str=(String)request.getSession().getAttribute("nuser");
		
//		jsr.setUid(udao.getUser(str).getUid());
//		jsr.setStatus("In progress");
		
		if(str!=null) {
			jsr.setUid(udao.getUser(str).getUid());
			jsr.setStatus("In progress");
			if(udao.storeRequestData(jsr)) {
				return true;
			}
		}
		return false;
	}

	public List<JobShadowPost> getJobPosts() {
		return pdao.getJobPosts();
	}
}
