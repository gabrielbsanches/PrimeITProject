package com.primeit.client.controller;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.primeit.client.model.Meeting;
import com.primeit.client.service.MeetingService;

/**
 * This class is the Controller of the Login Page 
 * 
 * @author gabrielbsanches
 *
 */
@Controller
public class LoginController {
	
	@Autowired private MeetingService meetingService;

	/**
	 * This method prints the Welcome page with Hello World.
	 * 
	 * @param	Model Map model
	 * @param 	Principal principal
	 * @return	
	 */
	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView printWelcome() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("WelcomeMessage", "Welcome to PrimeIT Clients System");
		addBasicInformationToView(modelAndView);
		return modelAndView;

	}
	
	@RequestMapping(value = {"/primeit**", "/primeit/*"  }, method = RequestMethod.GET)
	public ModelAndView adminPage() {
 
		ModelAndView model = new ModelAndView("admin");
		model.addObject("title", "PrimeIT Clients System");
		model.addObject("message", "This is protected page!");
		return model;
 
	}
	

	/**
	 * This method maps the login page
	 * 
	 * @param 	ModelMap model
	 * @return	Login Page
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
 
		ModelAndView model = new ModelAndView("login");
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}
 
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		return model;	
	}
	

	
	/**
     * Method to add information to the view:
     * 	clients
     * 	Username from SecurityContextHolder
     * 	Current Time
     * 
     * 
     * @param modelAndView
     */
    private void addBasicInformationToView(ModelAndView modelAndView){
    	User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	if(user.getUsername() != null){
    		modelAndView.addObject("username", user.getUsername());
    	}
    	
    	List<Meeting> lastWeekMeetings = meetingService.findbyWeek(0);
    	modelAndView.addObject("lastWeekMeetings", lastWeekMeetings);
    	
    	List<Meeting> currentWeekMeetings = meetingService.findbyWeek(1);
    	modelAndView.addObject("currentWeekMeetings", currentWeekMeetings);
    	
    	List<Meeting> nextWeekMeetings = meetingService.findbyWeek(2);
    	modelAndView.addObject("nextWeekMeetings", nextWeekMeetings);
    	
    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    	Calendar cal = Calendar.getInstance();
    	modelAndView.addObject("currentTime", dateFormat.format(cal.getTime()));
    }

}
