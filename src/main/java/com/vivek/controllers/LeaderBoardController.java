package com.vivek.controllers;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vivek.model.LeaderBoardColumnObj;
import com.vivek.service.LeaderBoardService;


@Controller
public class LeaderBoardController {
	
	@Autowired
	LeaderBoardService leaderBoardDao ;
	
	@RequestMapping(value="/leaderBoard" , method=RequestMethod.GET)
	public ModelAndView getLeaderBoard() {
		ModelAndView mv = new ModelAndView();
		LinkedList<LeaderBoardColumnObj> dataList = new LinkedList();
		dataList= leaderBoardDao.getDetails();
		int rowIndex=1;
		StringBuilder result = new StringBuilder();
		for (LeaderBoardColumnObj obj : dataList) {
			//System.out.println(obj.getName() +" "+obj.getUserId()+" "+obj.getScore());
			String str= " <tr>\r\n" + 
					"      <th scope=\" row\">"+Integer.toString(rowIndex)+"</th>\r\n" + 
					"      <td>"+ obj.getUserId() +"</td>\r\n" + 
					"      <td>"+ obj.getName()+"</td>\r\n" + 
					"      <td>"+ Integer.toString(obj.getScore())  +"</td>\r\n" + 
					"    </tr>\n";
			result.append(str);
			rowIndex++;
		}
		mv.addObject("result", result);
		mv.setViewName("LeaderBoard.jsp");
		return mv;
		//return "LeaderBoard.jsp";
	}
	
}
