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

import com.primeit.client.model.Client;
import com.primeit.client.service.ClientService;

/**
 * This class is the Controller of the Client Page
 * 
 * @author gabrielbsanches
 * 
 */
@Controller
public class ClientController {

	@Autowired
	private ClientService clientService;

	/**
	 * This method prints the Add Clients page.
	 * 
	 * @return ModelAndView add page
	 */
	@RequestMapping(value = "/primeit/client/add")
	public ModelAndView addClientPage() {
		ModelAndView modelAndView = new ModelAndView("client/add");
		modelAndView.addObject("client", new Client());

		addBasicInformationToView(modelAndView);
		return modelAndView;
	}

	/**
	 * This method controls when adding Clients in the system.
	 * 
	 * @param 	ModelAttibute Client client
	 * @return 	ModelAndView list page
	 */
	@RequestMapping(value = "/primeit/client/add/process")
	public ModelAndView addingClient(@ModelAttribute Client client) {
		String message = "";
		ModelAndView modelAndView = new ModelAndView("client/list");
		try {
			clientService.add(client);
		} catch (ConstraintViolationException e) {
			message = "Client Name or Client Code already exist";
			modelAndView.addObject("message", message);
			return modelAndView;
		}

		message = "Client was successfully added.";
		modelAndView.addObject("message", message);
		addBasicInformationToView(modelAndView);

		return modelAndView;
	}

	/**
	 * This method prints the List Clients page.
	 * 
	 * @return ModelAndView list page
	 */
	@RequestMapping(value = "/primeit/client/list")
	public ModelAndView listOfClients() {
		ModelAndView modelAndView = new ModelAndView("client/list");

		addBasicInformationToView(modelAndView);

		return modelAndView;
	}

	/**
	 * This method prints the Edit Clients page.
	 * 
	 * @param 	PathVariable Integer id
	 * @return 	ModelAndView edit page
	 */
	@RequestMapping(value = "/primeit/client/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editClientPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("client/edit");
		Client client = clientService.findByClientId(id);
		modelAndView.addObject("client", client);

		addBasicInformationToView(modelAndView);
		return modelAndView;
	}

	/**
	 * This method controls when editing Clients from the system.
	 * 
	 * @param 	ModelAttibute Client client
	 * @param 	PathVariable Integer id
	 * @return 	ModelAndView list page
	 */
	@RequestMapping(value = "/primeit/client/edit/{id}", method = RequestMethod.POST)
	public ModelAndView edditingClient(@ModelAttribute Client client, @PathVariable Integer id) {

		ModelAndView modelAndView = new ModelAndView("client/list");
		client.setClient_id(id);
		clientService.update(client);
		
		String message = "";
		if (client.getClient_company_name() != null) {
			message = "(" + client.getClient_company_name()	+ ") Client was successfully edited.";
		} else {
			message = "Client was successfully edited.";
		}

		modelAndView.addObject("message", message);
		addBasicInformationToView(modelAndView);
		return modelAndView;
	}

	/**
	 * This method controls when deleting Clients from the system.
	 * 
	 * @param	PathVariable Integer id
	 * @return 	ModelAndView list page
	 */
	@RequestMapping(value = "/primeit/client/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteClient(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("client/list");
		clientService.delete(id);
		String message = "Client was successfully deleted.";
		modelAndView.addObject("message", message);

		addBasicInformationToView(modelAndView);
		return modelAndView;
	}
	
	/**
	 * This method maps the ExtJS page
	 * 
	 * @param 	ModelMap
	 * @return 	ExtJS Page
	 */
	@RequestMapping(value = "/primeit/extjs/indexExtJS")
	public ModelAndView addExtJSPage() {
		ModelAndView modelAndView = new ModelAndView("indexExtJS");
		addBasicInformationToView(modelAndView);
		return modelAndView;
	}

	/**
     * Method to add general information to the view:
     * 	Existing Clients
     * 	Username of the Current user from SecurityContextHolder
     * 	Current Time as "yyyy/MM/dd HH:mm:ss"
     * 
     * @param modelAndView modelAndView
     */
	private void addBasicInformationToView(ModelAndView modelAndView) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (user.getUsername() != null) {
			modelAndView.addObject("username", user.getUsername());
		}
		List<Client> clients = clientService.findAll();
		modelAndView.addObject("clients", clients);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		modelAndView.addObject("currentTime", dateFormat.format(cal.getTime()));
	}

}
