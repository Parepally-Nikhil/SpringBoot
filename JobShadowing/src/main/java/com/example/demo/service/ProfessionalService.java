package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProfessionalDao;
import com.example.demo.dao.UserDao;
import com.example.demo.model.JobShadowPost;
import com.example.demo.model.JobShadowRequest;
import com.example.demo.model.ProfessionalUser;

@Service
public class ProfessionalService {

	@Autowired
	private ProfessionalDao pdao;
	
	@Autowired
	private UserDao udao;
	
	static int pseq=0;
	static int idseq=0;
	public boolean professionalSignUp(ProfessionalUser puser) {
		pseq++;
		puser.setPid("pro_"+pseq);
		if(pdao.addUser(puser)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean professionalLogin(ProfessionalUser puser) {
		ProfessionalUser pu=pdao.getUser(puser.getPemailId());
		if(pu!=null) {
			if(puser.getPpassword().equals(pu.getPpassword())) {
				return true;
			}
		}
		return false;
	}

	public boolean createPost(HttpServletRequest request, JobShadowPost post) {
		idseq++;
		post.setId(idseq);
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("professional");
		
//		String pid=pdao.getUser(email).getPid();
//		post.setPid(pid);
		
		if(email!=null) {
			String pid=pdao.getUser(email).getPid();
			post.setPid(pid);
			if(pdao.uploadPost(post)) {
				return true;
			}
		}
		return false;
	}

	public List<JobShadowPost> getPosts(HttpServletRequest request) {
		return pdao.getAllPosts(request);
	}

	public List<JobShadowRequest> getRequests(HttpServletRequest request) {
		
		List<JobShadowRequest> jrequests=new ArrayList<JobShadowRequest>();
		List<JobShadowRequest> jr=udao.getJobRequests();
		
		HttpSession session=request.getSession();
		String pemail=(String)session.getAttribute("professional");
		ProfessionalUser puser=pdao.getUser(pemail);
		
		for(int i=0;i<jrequests.size();i++) {
			if((jrequests.get(i).getPid()).equals(puser.getPid())) {
				jr.add(jrequests.get(i));
			}
		}
		
		return jr;
	}

	public boolean deletePost(HttpServletRequest request, int postId) {
		
		if(pdao.deletePost(request,postId)) {
			return true;
		}
		else {
			return false;
		}
	}
}
