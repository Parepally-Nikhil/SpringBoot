package com.example.demo.usercontrollers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
public class UserLoginController {
	@Autowired
	private UserService us;
	
	@GetMapping("userLoginController")
	@ResponseBody
	public ResponseEntity<String> getLoginData(HttpServletRequest request,@RequestBody User user){
		if(us.userLogin(user)) {
			HttpSession session=request.getSession();
			session.setAttribute("nuser", user.getUemailId());
			return new ResponseEntity<String>("You are logged in succssfully!",HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>("Wrong data entered.",HttpStatus.NOT_ACCEPTABLE);
	}
}
