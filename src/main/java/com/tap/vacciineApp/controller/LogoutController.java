package com.tap.vacciineApp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	public LogoutController() {
		System.out.println("LogoutController is Invoked");
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request,Model model)
	{
		System.out.println("logout is invoked");
		HttpSession session = request.getSession(false);// 'false' means do not create a new session if not exists
		
		if (session != null) {
			String n = (String) session.getAttribute("userEmail");
			System.out.println(n);
			session.invalidate();
		}
		return "/WEB-INF/Login.jsp";
	}

}
