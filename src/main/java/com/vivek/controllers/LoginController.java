package com.vivek.controllers;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.vivek.model.Login;
import com.vivek.service.LoginService;

@Controller
@SessionAttributes("username")
public class LoginController  {
	
	@Autowired
	LoginService loginDao;
	
	Login loginObject;
	
	@RequestMapping(value="/login")
	public String login() {
		return "index.jsp";
	}
	/*@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession hs=req.getSession();
	String userName=(String)req.getParameter("username");
	hs.setAttribute("username", userName);
	}*/
	
	
	@RequestMapping(value="/LoginSubmit", method=RequestMethod.POST)
	public ModelAndView loginSubmit(@RequestParam("username") String username , @RequestParam("password") String password ) {
		ModelAndView mv = new ModelAndView();
		loginObject = new Login(username , password);
		int errorMessage = loginDao.checkDetails(loginObject);
		String errorDisplay="document.getElementById(\"Error\").style.display=\"block\";";
		if(errorMessage==1) {
			String error="Error: UserName Doesn't Exist";
			mv.addObject("error",error);
			mv.addObject("errorDisplay",errorDisplay);
			mv.setViewName("index.jsp");
			return mv;
		}
		if(errorMessage==2) {
			String error="Error: Password Doesn't Match! ";
			mv.addObject("error",error);
			mv.addObject("errorDisplay",errorDisplay);
			mv.setViewName("index.jsp");
			return mv;
		}
		mv.addObject("username",username);
		
		//ServletContext sc=getServletContext();
		//sc.setAttribute("userName", username);
		
		
		mv.setViewName("GameHomePage.jsp");
		return mv;
	}

}
