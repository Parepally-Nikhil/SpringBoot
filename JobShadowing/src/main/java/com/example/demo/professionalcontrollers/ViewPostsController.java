package com.example.demo.professionalcontrollers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.model.JobShadowPost;
import com.example.demo.service.ProfessionalService;

@Controller
public class ViewPostsController {
	@Autowired
	private ProfessionalService ps;
	
	@GetMapping("viewPostsController")
	@ResponseBody
	public ResponseEntity<List<JobShadowPost>> getPosts(HttpServletRequest request){
		List<JobShadowPost> jposts=ps.getPosts(request);
			
		return new ResponseEntity<List<JobShadowPost>>(jposts,HttpStatus.ACCEPTED);
	}
}
