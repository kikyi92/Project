package com.mycompany.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.dto.UserListResponseDTO;
import com.mycompany.service.UserListService;
import com.mycompany.service.UserListServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	@Autowired
	UserListServiceImpl userListService;
	
	

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";

	}

	@RequestMapping(value="/DevelopmentTeam.do", method=RequestMethod.GET)
	public ModelAndView DevelopmentTeam (ModelAndView mv) {
		//Service call
		List<UserListResponseDTO> userlist = userListService.getUserListService();
		
		for(int i=0; i<userlist.size(); i++) {
			System.out.println("name: " + userlist.get(i).getUserName());
		}
		mv.addObject("listuser",userlist);
		mv.setViewName("/DevelopmentTeam");
		return mv;
	}
	
	
	
			
	
}
