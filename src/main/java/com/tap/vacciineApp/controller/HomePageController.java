package com.tap.vacciineApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
	
	@RequestMapping(value = "/gotHomePage")
	public String gotHomePage()
	{
		System.out.println("gotHomePage is invoked");
		return "/WEB-INF/HomePage.jsp";
		
	}

}
