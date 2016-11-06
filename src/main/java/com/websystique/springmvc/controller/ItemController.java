package com.websystique.springmvc.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websystique.springmvc.model.Item;
import com.websystique.springmvc.service.ItemService;
import org.apache.log4j.Logger;
@Controller
@RequestMapping("/")
public class ItemController {
	
	private static final Logger logger = Logger.getLogger(ItemController.class);
	
	@Autowired
	ItemService service;
	
	@Autowired
	MessageSource messageSource;

	/*
	 * This method will list all existing Items.
	 */
	@RequestMapping(value = {"/allitems" }, method = RequestMethod.GET)
	public String listItems(ModelMap model) {

		List<Item> Items = service.findAllItems();
		model.addAttribute("Items", Items);
		return "allitems";
	}

	/*
	 * This method will provide the medium to add a new Item.
	 */
	@RequestMapping(value = { "/insertItem" }, method = RequestMethod.GET)
	public String newItem(ModelMap model) {
		Item Item = new Item();
		model.addAttribute("item", Item);
		model.addAttribute("edit", false);
		return "insertItem";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving Item in database. It also validates the user input
	 */
	@RequestMapping(value = { "/insertItem" }, method = RequestMethod.POST)
	public String saveItem(@Valid Item Item, BindingResult result,
			ModelMap model) {
		
		//logs debug message
				if(logger.isDebugEnabled()){
					logger.debug("getWelcome is executed!");
				}
				//logs exception
				logger.error("This is Error message", new Exception("Testing"));
				logger.info(Item.toString());
				if (result.hasErrors()) {
			return "insertItem";
		}

		/*
		 * Preferred way to achieve uniqueness of field [ImageLink] should be implementing custom @Unique annotation 
		 * and applying it on field [ImageLink] of Model class [Item].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 * 
		 */
		if(!service.isItemNameUnique(Item.getId(), Item.getName())){
			FieldError ItemNameError =new FieldError("Item","name",messageSource.getMessage("non.unique.itemname", new String[]{Item.getName()}, Locale.getDefault()));
		    result.addError(ItemNameError);
			return "insertItem";
		}
		
		service.saveItem(Item);

		model.addAttribute("success", "Item " + Item.getName() + " inserted successfully");
		return "successItem";
	}


	/*
	 * This method will provide the medium to update an existing Item.
	 */
//	@RequestMapping(value = { "/edit-{ImageLink}-Item" }, method = RequestMethod.GET)
//	public String editItem(@PathVariable String ImageLink, ModelMap model) {
//		Item Item = service.findItemByImageLink(ImageLink);
//		model.addAttribute("Item", Item);
//		model.addAttribute("edit", true);
//		return "registration";
//	}
	
	/*
	 * This method will be called on form submission, handling POST request for
	 * updating Item in database. It also validates the user input
	 */
//	@RequestMapping(value = { "/edit-{ImageLink}-Item" }, method = RequestMethod.POST)
//	public String updateItem(@Valid Item Item, BindingResult result,
//			ModelMap model, @PathVariable String ImageLink) {
//
//		if (result.hasErrors()) {
//			return "registration";
//		}
//
//		if(!service.isItemImageLinkUnique(Item.getId(), Item.getImageLink())){
//			FieldError ImageLinkError =new FieldError("Item","ImageLink",messageSource.getMessage("non.unique.ImageLink", new String[]{Item.getImageLink()}, Locale.getDefault()));
//		    result.addError(ImageLinkError);
//			return "registration";
//		}
//
//		service.updateItem(Item);
//
//		model.addAttribute("success", "Item " + Item.getName()	+ " updated successfully");
//		return "success";
//	}

	
	/*
	 * This method will delete an Item by it's ImageLink value.
	 */
//	@RequestMapping(value = { "/delete-{ImageLink}-Item" }, method = RequestMethod.GET)
//	public String deleteItem(@PathVariable String ImageLink) {
//		service.deleteItemByImageLink(ImageLink);
//		return "redirect:/allitems";
//	}

}
