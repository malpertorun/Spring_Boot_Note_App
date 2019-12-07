package com.example.web.abc.controller;

import com.example.web.abc.domain.Item;
import com.example.web.abc.domain.ItemAddForm;
import com.example.web.abc.domain.ItemAssignForm;
import com.example.web.abc.domain.User;
import com.example.web.abc.service.ItemService;
import com.example.web.abc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@Controller
public class ItemController {
	private final ItemService itemService;
	private final UserService userService;

	@Autowired
	public ItemController(ItemService itemService, UserService userService) {
		this.itemService = itemService;
		this.userService = userService;
	}

	@RequestMapping("/items")
	public ModelAndView getItemsPage() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("items", itemService.getItems());
		model.put("usernames", userService.getUsernames());
		model.put("assignForm", new ItemAssignForm());
		return new ModelAndView("items", model);
	}


	@RequestMapping("/items/add")
	public ModelAndView itemAddPage() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemForm", new ItemAddForm());
		model.put("usernames", userService.getUsernames());
		return new ModelAndView("addItem", model);
	}

	@RequestMapping(value = "/items", method = RequestMethod.POST)
	public String handleItemAdd(@Valid @ModelAttribute("itemForm") ItemAddForm form, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "addItem";

		itemService.addItem(form);

		return "redirect:/";
	}

	
}
