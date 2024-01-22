package com.example.demo.professionalcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.ProfessionalDao;
import com.example.demo.model.ProfessionalUser;
import com.example.demo.service.ProfessionalService;

@Controller
public class ProfessionalSignUpController {
	@Autowired
	private ProfessionalService ps;
	
	@Autowired
	private ProfessionalDao pdao;
	
	@PostMapping("professionalSignUpController")
	@ResponseBody
	public ResponseEntity<String> getProfessionalData(@RequestBody ProfessionalUser puser) {
		if(ps.professionalSignUp(puser)) {
			
			String str=pdao.getUser(puser.getPemailId()).getPid();
			
			return new ResponseEntity<String>("Registered Successfully.\nYour Professsional id:"+str,HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Wrong data entered.",HttpStatus.NOT_ACCEPTABLE);
	}
	
}
