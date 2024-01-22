package com.example.demo.professionalcontrollers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.model.JobShadowRequest;
import com.example.demo.service.ProfessionalService;

@Controller
public class ViewRequestsController {
	@Autowired
	private ProfessionalService ps;
	
	@GetMapping("viewRequestsController")
	@ResponseBody
	public ResponseEntity<List<JobShadowRequest>> getRequests(HttpServletRequest request){
		List<JobShadowRequest> jrequests=ps.getRequests(request);
			
		return new ResponseEntity<List<JobShadowRequest>>(jrequests,HttpStatus.ACCEPTED);
	}
}
