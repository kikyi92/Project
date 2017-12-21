package com.mycompany.myapp;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.dto.UserListResponseDTO;
import com.mycompany.service.UserListServiceImpl;

/** * Handles requests for the application home page. */
@Controller
public class HomeController {

	@Autowired
	UserListServiceImpl userListService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**	 * Simply selects the home view to render by returning its name.  */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		return "home";
	}
	//TE
	@RequestMapping(value = "/ajax_call2.do", method = RequestMethod.POST) //do 
	public ModelAndView ajax_call2(ModelAndView mv) {
		// Service call2
		List<UserListResponseDTO> userlist = userListService.getUserListService1();
		for (int i = 0; i < userlist.size(); i++) {
			System.out.print("이름: " + userlist.get(i).getUsername());
			System.out.print("성별: " + userlist.get(i).getUserGender());
			System.out.print("나이: " + userlist.get(i).getUserAge());
			System.out.println("핸드폰번호: " + userlist.get(i).getUserPhone());
		}
		mv.addObject("listuser", userlist);
		mv.setViewName("ajax_call2");
		return mv;
	}
	//ST
	
	@RequestMapping(value = "/DevelopmentTeam.do", method = RequestMethod.GET)
	public ModelAndView DevelopmentTeam(ModelAndView mv) {
		// Service call
		List<UserListResponseDTO> userlist = userListService.getUserListService();
		for (int i = 0; i < userlist.size(); i++) {
			System.out.print("이름: " + userlist.get(i).getUsername());
			System.out.print("성별: " + userlist.get(i).getUserGender());
			System.out.print("나이: " + userlist.get(i).getUserAge());
			System.out.println("핸드폰번호: " + userlist.get(i).getUserPhone());
		}
		mv.addObject("listuser", userlist);
		mv.setViewName("/DevelopmentTeam");
		return mv;
	}
}
