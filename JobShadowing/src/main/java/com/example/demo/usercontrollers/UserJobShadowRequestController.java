package com.example.demo.usercontrollers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.JobShadowRequest;
import com.example.demo.service.UserService;

@Controller
public class UserJobShadowRequestController {
	
	@Autowired
	private UserService us;
	
	@PostMapping("userJobShadowRequestController")
	@ResponseBody
	public ResponseEntity<String> getJobShadowRequestData(HttpServletRequest request,@RequestBody JobShadowRequest jsr){
			
		if(us.storeJobShadowRequest(request,jsr)) {
			return new ResponseEntity<String>("Your job shadow request sent successfully wait for approval ",HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>("Wrong data entered.",HttpStatus.NOT_ACCEPTABLE);
	}
}
