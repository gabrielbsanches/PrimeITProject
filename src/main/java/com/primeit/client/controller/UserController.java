package com.primeit.client.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.primeit.client.model.User;
import com.primeit.client.service.UserService;

@Controller
public class UserController {

	@Autowired private UserService userService;
	
	@RequestMapping(value="/primeit/user/add")
    public ModelAndView addUserPage() {
        ModelAndView modelAndView = new ModelAndView("user/addUser");
        modelAndView.addObject("user", new User());
        addBasicInformationToView(modelAndView);
        return modelAndView;
    }
	
	@RequestMapping(value="/primeit/user/add/process")
	public ModelAndView addingUser(@ModelAttribute com.primeit.client.model.User user) {
		String message = "";
		ModelAndView modelAndView = new ModelAndView("user/listUsers");
	   try {
		   userService.add(user);
		} catch (ConstraintViolationException e) {
			message = "User already exist";
			modelAndView.addObject("message", message);
			return modelAndView;
		}
	
	   message = "User was successfully added.";
	   modelAndView.addObject("message", message);
	   addBasicInformationToView(modelAndView);
	     
	   return modelAndView;
	}
	
    @RequestMapping(value="/primeit/user/list")
    public ModelAndView listOfUsers() {
        ModelAndView modelAndView = new ModelAndView("user/listUsers");
         
        addBasicInformationToView(modelAndView);
         
        return modelAndView;
    }
     
    @RequestMapping(value="/primeit/user/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editUsertPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("user/editUser");
        User user = userService.findByUserId(id);
        modelAndView.addObject("user", user);
        
        addBasicInformationToView(modelAndView);
        return modelAndView;
    }
     
    @RequestMapping(value="/primeit/user/edit/{id}", method=RequestMethod.POST)
    public ModelAndView edditingUser(@ModelAttribute User user, @PathVariable Integer id) {
         
        ModelAndView modelAndView = new ModelAndView("user/listUsers");
        user.setUserid(id); 
        userService.update(user);
        String message = "";
        if(user.getManager_name() != null){
        	message = "(" + user.getManager_name() + ") User was successfully edited.";
        }else{
        	message = "User was successfully edited.";
        }
        
        modelAndView.addObject("message", message);
        
        addBasicInformationToView(modelAndView);
         
        return modelAndView;
    }
     
    @RequestMapping(value="/primeit/user/delete/{id}", method=RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("user/listUsers");
        userService.delete(id);
        String message = "User was successfully deleted.";
        modelAndView.addObject("message", message);
        
        addBasicInformationToView(modelAndView);
        
        return modelAndView;
    }
	
	 /**
     * Method to add information to the view:
     * 	Users
     * 	Username from SecurityContextHolder
     * 	Current Time
     * 
     * 
     * @param modelAndView
     */
    private void addBasicInformationToView(ModelAndView modelAndView){
    	org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	if(user.getUsername() != null){
    		modelAndView.addObject("username", user.getUsername());
    	}
    	List<User> users = userService.findAll();
    	modelAndView.addObject("users", users);
    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    	Calendar cal = Calendar.getInstance();
    	modelAndView.addObject("currentTime", dateFormat.format(cal.getTime()));
    }
}
