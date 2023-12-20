package com.tap.vacciineApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.vacciineApp.service.RegisterService;

@Controller
public class RegisterContoller {
	public RegisterContoller() {
		System.out.println("RegisterContoller invoked");
	}
	
	private RegisterService registerService;

	@Autowired
	protected RegisterContoller(RegisterService registerService) {
		super();
		this.registerService = registerService;
	}

	@RequestMapping(value = "/gotoregisterPage")
	public String getRegister()
	{
		System.out.println("getRegister is invoked");
		return "/WEB-INF/Register.jsp";
	}
	
	@RequestMapping(value = "/saveRegisterEntity")
	public String saveRegisterEntity(
			@RequestParam String username,
			@RequestParam String email,
			@RequestParam String password,
			@RequestParam String mobileNumber,
			@RequestParam String gender,
			@RequestParam String dob,
			Model model
			)
	{
		System.out.println("saveRegisterEntity is invoked");
		System.err.println("username "+username);
		System.err.println("email "+email);
		System.err.println("password "+password);
		System.err.println("mobileNumber "+mobileNumber);
		System.err.println("gender "+gender);
		System.err.println("dob "+dob);
		
		
		boolean validateRegister = registerService.validateRegister(username, email, password, mobileNumber, gender, dob);
		if (validateRegister) {
			model.addAttribute("responseMessage", "data is valid & saved in database");
			model.addAttribute("emailresponseMessage", "Mail Sent to your Register Email For Login");
		}
		else {
			model.addAttribute("eresponseMessage", "data is invalid & try again...");
			model.addAttribute("emailErrorresponseMessage", "Registration has Been Failed");
		}
		return "/WEB-INF/Register.jsp";
	}
}

