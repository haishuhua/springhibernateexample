package com.websystique.springmvc.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websystique.springmvc.model.User;
import com.websystique.springmvc.service.UserService;
@Controller
@RequestMapping("/")
public class UserController {
	
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	UserService service;
	
	@Autowired
	MessageSource messageSource;

	/*
	 * This method will list all existing Users.
	 */
	@RequestMapping(value = {"/allusers" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {

		List<User> Users = service.findAllUsers();
		model.addAttribute("Users", Users);
		return "allusers";
	}

	/*
	 * This method will provide the medium to add a new User.
	 */
	@RequestMapping(value = { "/insertUser" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		User User = new User();
		model.addAttribute("user", User);
		model.addAttribute("edit", false);
		return "insertUser";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving User in database. It also validates the user input
	 */
	@RequestMapping(value = { "/insertUser" }, method = RequestMethod.POST)
	public String saveUser(@Valid User User, BindingResult result,
			ModelMap model) {
		
		//logs debug message
				if(logger.isDebugEnabled()){
					logger.debug("getWelcome is executed!");
				}
				//logs exception
				logger.error("This is Error message", new Exception("Testing"));
				logger.info(User.toString());
				if (result.hasErrors()) {
			return "insertUser";
		}

		/*
		 * Preferred way to achieve uniqueness of field [ImageLink] should be implementing custom @Unique annotation 
		 * and applying it on field [ImageLink] of Model class [User].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 * 
		 */
		if(!service.isUserNameUnique(User.getId(), User.getName())){
			FieldError UserNameError =new FieldError("User","name",messageSource.getMessage("non.unique.username", new String[]{User.getName()}, Locale.getDefault()));
		    result.addError(UserNameError);
			return "insertUser";
		}
		
		service.saveUser(User);

		model.addAttribute("success", "User " + User.getName() + " inserted successfully");
		return "successUser";
	}


	/*
	 * This method will provide the medium to update an existing User.
	 */
//	@RequestMapping(value = { "/edit-{ImageLink}-User" }, method = RequestMethod.GET)
//	public String editUser(@PathVariable String ImageLink, ModelMap model) {
//		User User = service.findUserByImageLink(ImageLink);
//		model.addAttribute("User", User);
//		model.addAttribute("edit", true);
//		return "registration";
//	}
	
	/*
	 * This method will be called on form submission, handling POST request for
	 * updating User in database. It also validates the user input
	 */
//	@RequestMapping(value = { "/edit-{ImageLink}-User" }, method = RequestMethod.POST)
//	public String updateUser(@Valid User User, BindingResult result,
//			ModelMap model, @PathVariable String ImageLink) {
//
//		if (result.hasErrors()) {
//			return "registration";
//		}
//
//		if(!service.isUserImageLinkUnique(User.getId(), User.getImageLink())){
//			FieldError ImageLinkError =new FieldError("User","ImageLink",messageSource.getMessage("non.unique.ImageLink", new String[]{User.getImageLink()}, Locale.getDefault()));
//		    result.addError(ImageLinkError);
//			return "registration";
//		}
//
//		service.updateUser(User);
//
//		model.addAttribute("success", "User " + User.getName()	+ " updated successfully");
//		return "success";
//	}

	
	/*
	 * This method will delete an User by it's ImageLink value.
	 */
//	@RequestMapping(value = { "/delete-{ImageLink}-User" }, method = RequestMethod.GET)
//	public String deleteUser(@PathVariable String ImageLink) {
//		service.deleteUserByImageLink(ImageLink);
//		return "redirect:/allusers";
//	}

}
