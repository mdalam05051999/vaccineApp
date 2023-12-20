package com.tap.vacciineApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.vacciineApp.service.ResetPasswordService;

@Controller
public class ResetPasswordController {
	
	public ResetPasswordController() {
		System.out.println("ResetPasswordController is invoked");
	}
	
	private ResetPasswordService resetPasswordService;
	@Autowired
	protected ResetPasswordController(ResetPasswordService resetPasswordService) {
		super();
		this.resetPasswordService = resetPasswordService;
	}

	@RequestMapping(value = "/gotoResetPassword")
	public String gotoResetPassword()
	{
		System.out.println("gotoResetPassword is invoked");
		return "/WEB-INF/ResetPassword.jsp";
	}
	
	@RequestMapping(value = "/getResetPassword")
	public String getResetPassword(
			@RequestParam String email,
			@RequestParam String password,
			Model model)
	{
		System.out.println("getResetPassword() is invoked");
		System.out.println("email "+email);
		System.out.println("password "+password);
		
		boolean validateResetPsssword = resetPasswordService.validateResetPsssword(email, password);
		if (validateResetPsssword) {
			model.addAttribute("yes", "Password has been Reset Please Check your Email for Password. Click on Login Button and Sign in");
			return "/WEB-INF/ResetPassword.jsp";
		} else {
			model.addAttribute("no", "Password Reset has been Failed");
			return "/WEB-INF/ResetPassword.jsp";
		}
		
	}

}
