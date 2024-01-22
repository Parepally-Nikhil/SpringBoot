package com.example.demo.professionalcontrollers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.service.ProfessionalService;

@Controller
public class DeletePostController {

	@Autowired
	ProfessionalService ps;
	
	@DeleteMapping("deletePostController/{postId}")
	public ResponseEntity<String> deletePost(HttpServletRequest request,@PathVariable("postId") int postId){
		if(ps.deletePost(request,postId)) {		
			return new ResponseEntity<String>("Your post deleted successfully.",HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>("Wrong data entered.",HttpStatus.NOT_ACCEPTABLE);
	}
}
