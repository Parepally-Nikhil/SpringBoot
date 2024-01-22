package com.example.demo.usercontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
public class UserSignUpController {
	@Autowired
	private UserService us;
	
	@Autowired
	private UserDao ud;
	@PostMapping("userSignUpController")
	@ResponseBody
	public ResponseEntity<String> getProfessionalData(@RequestBody User user) {
		if(us.userSignUp(user)) {
			String str=ud.getUser(user.getUemailId()).getUid();
			return new ResponseEntity<String>("Registered Successfully.\nYour User id:"+str,HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Wrong data entered.",HttpStatus.CREATED);
	}
}
