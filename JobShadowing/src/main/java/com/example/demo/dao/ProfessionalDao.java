package com.example.demo.dao;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.example.demo.model.JobShadowPost;
import com.example.demo.model.ProfessionalUser;

@Component
public class ProfessionalDao {
//	static int seq=0;
	
	ArrayList<ProfessionalUser> pusers=new ArrayList<ProfessionalUser>();
	ArrayList<JobShadowPost> jobPosts=new ArrayList<JobShadowPost>();

	public ArrayList<JobShadowPost> getJobPosts() {
		return jobPosts;
	}

	public boolean addUser(ProfessionalUser puser) {
		
//		seq++;
//		puser.setPid("pro_"+seq);
		
		if(pusers.add(puser)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public ProfessionalUser getUser(String pemailId) {
		for(int i=0;i<pusers.size();i++) {
			if((pusers.get(i).getPemailId()).equals(pemailId)) {
				return pusers.get(i);
			}
		}
		return null;
	}

	public boolean uploadPost(JobShadowPost post) {
		if(jobPosts.add(post)) {
			return true;
		}
		else {
			return false;
		}
	}

	public List<JobShadowPost> getAllPosts(HttpServletRequest request) {
		List<JobShadowPost> posts=new ArrayList<JobShadowPost>();
		HttpSession session=request.getSession();
		String pemail=(String)session.getAttribute("professional");
		ProfessionalUser puser=getUser(pemail);
		for(int i=0;i<jobPosts.size();i++) {
			if((jobPosts.get(i).getPid()).equals(puser.getPid())) {
				posts.add(jobPosts.get(i));
			}
		}
		return posts;
	}

	public boolean deletePost(HttpServletRequest request, int postId) {
		HttpSession session=request.getSession();
		String pemail=(String)session.getAttribute("professional");
		ProfessionalUser puser=getUser(pemail);
		
		for(int i=0;i<jobPosts.size();i++) {
			if(((jobPosts.get(i).getPid()).equals(puser.getPid())) && jobPosts.get(i).getId()==postId) {
				jobPosts.remove(i);
				return true;
			}
		}
		return false;
	}
}
