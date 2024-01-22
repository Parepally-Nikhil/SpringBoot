package com.example.demo.usercontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.JobShadowPost;
import com.example.demo.service.UserService;

@Controller
public class ViewJobShadowPostsController {
	@Autowired
	private UserService us;
	
	@GetMapping("viewJobShadowPostsController")
	@ResponseBody
	public ResponseEntity<List<JobShadowPost>> getJobPosts(){
		List<JobShadowPost> jposts=us.getJobPosts();
			
		return new ResponseEntity<List<JobShadowPost>>(jposts,HttpStatus.ACCEPTED);
	}
}
