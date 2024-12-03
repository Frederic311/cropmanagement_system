package com.group2.cropmanagement.controller;

import Group1.Crop_Management.DTO.UserDTO;
import Group1.Crop_Management.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;


@Controller
public class 	UserController {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	
	/**
	@GetMapping("/landing")
	public String landing()
	{
		return "landing";
	}
	**/
	
	@GetMapping("/registration")
	public String getRegistrationPage(@ModelAttribute("user") UserDTO userDTO) {
		return "register";
	}
	
	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") UserDTO userDTO, Model model) {
		userService.save(userDTO);
		model.addAttribute("message", "Registered Successfuly!");
		return "login";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/")
	public String homePage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "home";
	}

//	@GetMapping("/admin-home")
//	public String adminPage (Model model, Principal principal) {
//		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
//		model.addAttribute("user", userDetails);
//		return "admin-home";
//	}

	@GetMapping("/error")
	public String errorPage (Model model) {
		return "error";
	}


}
