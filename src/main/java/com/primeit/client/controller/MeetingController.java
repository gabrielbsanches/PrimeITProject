package com.primeit.client.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.primeit.client.model.Meeting;
import com.primeit.client.service.ClientService;
import com.primeit.client.service.MeetingService;
import com.primeit.client.service.UserService;

/**
 * This class is the Controller of the Meeting Page
 * 
 * @author gabrielbsanches
 *
 */
@Controller
public class MeetingController {

	@Autowired
	private MeetingService meetingService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private UserService userService;

	/**
	 * This method prints the Add Meeting page.
	 * 
	 * @return ModelAndView addMeeting page
	 */
	@RequestMapping(value = "/primeit/meeting/add")
	public ModelAndView addMeetingPage() {
		ModelAndView modelAndView = new ModelAndView("meeting/addMeeting");
		modelAndView.addObject("meeting", new Meeting());
		
		addManagerClientCompanyInformation(modelAndView);
		addBasicInformationToView(modelAndView);
		return modelAndView;
	}

	/**
	 * This method controls when adding Meetings in the system.
	 * 
	 * @param 	ModelAttribute Meeting meeting
	 * @return 	ModelAndView listMeetings page
	 */
	@RequestMapping(value = "/primeit/meeting/add/process")
	public ModelAndView addingMeeting(@ModelAttribute Meeting meeting) {
		String message = "";
		ModelAndView modelAndView = new ModelAndView("meeting/listMeetings");
		try {
			meetingService.add(meeting);
		} catch (ConstraintViolationException e) {
			message = "Meeting already exist";
			modelAndView.addObject("message", message);
			return modelAndView;
		}

		message = "Meeting was successfully added.";
		modelAndView.addObject("message", message);
		addBasicInformationToView(modelAndView);
		return modelAndView;
	}

	/**
	 * This method prints the List Meeting page.
	 * 
	 * @return ModelAndView listMeetings page
	 */
	@RequestMapping(value = "/primeit/meeting/list")
	public ModelAndView listOfMeetings() {
		ModelAndView modelAndView = new ModelAndView("meeting/listMeetings");

		addBasicInformationToView(modelAndView);
		return modelAndView;
	}

	/**
	 * This method prints the Edit Meetings page.
	 * 
	 * @param	PathVariable Integer id
	 * @return	ModelAndView editMeeting page
	 */
	@RequestMapping(value = "/primeit/meeting/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editMeetingPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("meeting/editMeeting");
		Meeting meeting = meetingService.findByMeetingId(id);
		modelAndView.addObject("meeting", meeting);

		addManagerClientCompanyInformation(modelAndView);
		return modelAndView;
	}

	/**
	 * This method controls when editing Meetings from the system.
	 * 
	 * @param	ModelAttribute Meeting meeting
	 * @param	PathVariable Integer id
	 * @return 	ModelAndView listMeetings page
	 */
	@RequestMapping(value = "/primeit/meeting/edit/{id}", method = RequestMethod.POST)
	public ModelAndView edditingMeeting(@ModelAttribute Meeting meeting, @PathVariable Integer id) {

		ModelAndView modelAndView = new ModelAndView("meeting/listMeetings");
		meeting.setMeeting_id(id);
		meetingService.update(meeting);

		if (meeting.getManager_name() != null) {
			modelAndView.addObject("message", "The manager " + meeting.getManager_name()
							+ "successfully edited the meeting with id "
							+ meeting.getMeeting_id() + ".");
		} else {
			modelAndView.addObject("message","Meeting was successfully edited.");
		}
		
		addBasicInformationToView(modelAndView);
		return modelAndView;
	}

	/**
	 * This method controls when deleting Meetings from the system.
	 * 
	 * @param	PathVariable Integer id
	 * @return 	ModelAndView listMeetings page
	 */
	@RequestMapping(value = "/primeit/meeting/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteMeeting(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("meeting/listMeetings");
		meetingService.delete(id);
		String message = "Meeting was successfully deleted.";
		modelAndView.addObject("message", message);

		addBasicInformationToView(modelAndView);

		return modelAndView;
	}

	/**
     * Method to add general information to the view:
     * 	Existing Clients
     * 	Username of the Current user from SecurityContextHolder
     * 	Current Time as "yyyy/MM/dd HH:mm:ss"
     * 
     * @param modelAndView modelandView
     */
	private void addBasicInformationToView(ModelAndView modelAndView) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (user.getUsername() != null) {
			modelAndView.addObject("username", user.getUsername());
		}
		List<Meeting> meetings = meetingService.findAll();
		modelAndView.addObject("meetings", meetings);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		modelAndView.addObject("currentTime", dateFormat.format(cal.getTime()));
	}

	/**
	 * This method is used in Edit and Add page of Meeting scenario in order to
	 * populate all combo box with information. This case is Manager Names,
	 * Company Names and direct Client Names.
	 * 
	 * @param ModelandView view
	 */
	private void addManagerClientCompanyInformation(ModelAndView view) {
		view.addObject("clientCompanyNames",
				clientService.findAllClientCompanyNames());
		view.addObject("clientNames", clientService.findAllClientNames());
		view.addObject("managerNames", userService.findAllManagerNames());
	}

}
