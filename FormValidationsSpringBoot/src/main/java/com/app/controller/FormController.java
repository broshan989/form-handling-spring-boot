package com.app.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.model.User;

@Controller
public class FormController {
	
	@RequestMapping("/")
	public String indexMethod(Model m) {
		m.addAttribute("hello", "Form Handling with Spring Boot and Thymeleaf");
		return "index";
	}
	
	@RequestMapping("/form-handle")
	public  String showForm(Model m) {
		m.addAttribute("user", new User());
		return "form";
	}
	
	@PostMapping("/info")
	public String processInfo(@Valid @ModelAttribute User user, BindingResult bindingResult) {
		System.out.println(user);
		
		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "form";
		}
		
		return "info";
	}
}
