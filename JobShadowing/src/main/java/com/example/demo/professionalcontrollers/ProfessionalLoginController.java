package com.example.demo.professionalcontrollers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.ProfessionalUser;
import com.example.demo.service.ProfessionalService;

@Controller
public class ProfessionalLoginController {

	@Autowired
	private ProfessionalService ps;
	
	@GetMapping("professionalLoginController")
	@ResponseBody
	public ResponseEntity<String> getLoginData(HttpServletRequest request,@RequestBody ProfessionalUser puser){
		if(ps.professionalLogin(puser)) {
			HttpSession session=request.getSession();
			session.setAttribute("professional", puser.getPemailId());
			return new ResponseEntity<String>("You are logged in succssfully!",HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>("Wrong data entered.",HttpStatus.NOT_ACCEPTABLE);
	}
}
