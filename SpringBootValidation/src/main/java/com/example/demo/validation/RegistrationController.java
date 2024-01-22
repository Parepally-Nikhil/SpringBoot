package com.example.demo.validation;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {
	@RequestMapping("registrationForm")
	public String registerForm(Model m) {
		m.addAttribute("emp",new Employee());
		return "empRegistration.jsp";
	}
	@RequestMapping("empSubmitForm")
    public String submitForm(HttpServletRequest request, @Valid @ModelAttribute("emp") Employee e, BindingResult br,Employee emp)
    {
        if(br.hasErrors())
        {
            return "empRegistration.jsp";
        }
        else
        {
        return "finalpage.jsp";
        }
    }
}
