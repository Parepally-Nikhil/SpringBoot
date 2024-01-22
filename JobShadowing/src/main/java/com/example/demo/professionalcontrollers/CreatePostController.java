package com.example.demo.professionalcontrollers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.JobShadowPost;
import com.example.demo.service.ProfessionalService;

@Controller
public class CreatePostController {
	
	@Autowired
	private ProfessionalService ps;
	
	@PostMapping("createPostController")
	public ResponseEntity<String> createPost(HttpServletRequest request,@RequestBody JobShadowPost post){
		if(ps.createPost(request,post)) {
			
			return new ResponseEntity<String>("Your post uploaded successfully.",HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Wrong data entered.",HttpStatus.NOT_ACCEPTABLE);
	}
}
