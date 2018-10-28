package com.vivek.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vivek.model.SignUp;
import com.vivek.service.SignUpService;

@Controller
@Scope("session")
public class SignUpController {
	
	@Autowired
	SignUpService signUpDao ;
	
	SignUp signUpObject;
	@RequestMapping(value="/SignUp")
	public String signUp() {
		return "SignUp.jsp";
	}
	
	@RequestMapping(value="/SignUpSubmit", method=RequestMethod.POST)
	public ModelAndView SignUpSubmit(@RequestParam("fistName") String firstName ,@RequestParam("lastName") String lastName ,@RequestParam("username") String username ,@RequestParam("emailID") String emailId , @RequestParam("setPassword") String setPassword,@RequestParam("confirmPassword") String confirmPassword ) {
		ModelAndView mv = new ModelAndView();
		String errorDisplay="document.getElementById(\"Error\").style.display=\"block\";";
		if(!setPassword.equals(confirmPassword)) {
			String error = "Error: Password Doesn't Match!";
			
			mv.addObject("error",error);
			mv.addObject("errorDisplay",errorDisplay);
			mv.setViewName("SignUp.jsp");
			return mv;
		}
		signUpObject = new SignUp(firstName,lastName,username,emailId,setPassword);
		//System.out.println(signUpObject.toString());
		if(!signUpDao.AddDetails(signUpObject)) {
			String error = "Error: Choose Unique UserId";
			mv.addObject("error",error);
			mv.addObject("errorDisplay",errorDisplay);
			mv.setViewName("SignUp.jsp");
			return mv;
		}
		
		mv.setViewName("index.jsp");
		return mv;
	}

}
