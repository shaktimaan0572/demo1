package com.vivek.controllers;



import java.io.IOException;
/*
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.vivek.model.Login;
import com.vivek.service.GameService;

@Controller
@SessionAttributes("username")
public class GameController {
	/*String username;
	  @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs= req.getSession();
		username=(String)hs.getAttribute("username");
	}
	*/
	@Autowired
	GameService gameDao;
	//Login l; 
	//ServletContext sc=getServletContext();
	
	//Login loginobj;
	@RequestMapping(value="/SingleGame")
	public ModelAndView singleGame(@ModelAttribute("username") String username ) {
		
		
		//String username= l.getUsername();
		ModelAndView mv = new ModelAndView();
		System.out.println(username);
		mv.addObject("username",username);
		mv.setViewName("GamePlay.jsp");
		return mv;
	}
	
	@RequestMapping(value="/Mutiplayer")
	public String multiplayer() {
		return "MatchMaking.jsp";
	}
	
	@RequestMapping(value="/GameSubmit" )
	public String gameSubmit(@RequestParam("result") String Gameresult, @RequestParam("score1") String score1, @ModelAttribute("username") String userId ,@RequestParam("score2") String score2  ) {
		//String userId=(String)sc.getAttribute("userName");
		//String userId="";
		
		int points=0;
		int win=0;
		if(Gameresult.equals("YOU WIN")) {
			points=Integer.parseInt(score1);
			win=1;
		}else {
			points= Integer.parseInt(score1) - Integer.parseInt(score2);
			
		}
		gameDao.updateScore(points, win, userId);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "GameHomePage.jsp";
	}
	

}
