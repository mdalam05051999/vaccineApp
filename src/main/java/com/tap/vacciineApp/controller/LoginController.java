package com.tap.vacciineApp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.vacciineApp.entity.RegisterEntity;
import com.tap.vacciineApp.service.LoginService;

@Controller
public class LoginController {

	public LoginController() {
		System.out.println("LoginController is invoked");
	}
	
	private static final int maxLoginAttempt = 2;
	
	private LoginService loginService;	
	@Autowired
	protected LoginController(LoginService loginService) {
		super();
		this.loginService = loginService;
	}


	@RequestMapping(value = "/gotoLoginPage")
	public String getLogin()
	{
		System.out.println("getLogin is invoked");
		return "/WEB-INF/Login.jsp";
	}
	
	@RequestMapping(value = "/getLoginData")
	public String getLoginData(
			@RequestParam String email,
			@RequestParam String password,
			Model model,
			HttpServletRequest request
			)
	{
		System.out.println("saveRegisterEntity is invoked");
		System.out.println("username "+email);
		System.out.println("password "+password);
		boolean validateLogin = loginService.validateLogin(email, password);
		 if (validateLogin) {
		        RegisterEntity entity = loginService.getRegisterEntityByEmail(email);
		        if (entity != null) {
		            if (loginService.loginDetailsCheck(email, password)) {
		                model.addAttribute("yes", "Login Successful.");
		                HttpSession session = request.getSession(true);
		                session.setAttribute("userEmail", email);
		                
		             // Store the original URL in the session
		                String originalUrl = request.getRequestURI() + "?" + request.getQueryString();
		                session.setAttribute("originalUrl", originalUrl);
		                
		                int membercount = entity.getMemberCount();
		                model.addAttribute("memberCounts",membercount);
		                return "/WEB-INF/HomePage.jsp";
		            } else {
		                if(entity.getLoginAttempt()>maxLoginAttempt) {
		                    model.addAttribute("no", "Your account is blocked due to too many failed login attempts");
		                } else {
		                    model.addAttribute("no", "Invalid Login Credentials");
		                }
		                return "/WEB-INF/Login.jsp";
		            }
		        } else {
		            model.addAttribute("no", "Username does not exist");
		            return "/WEB-INF/Login.jsp";
		        }

		    } else {
		        model.addAttribute("no", "Invalid Login Credentials");
		        return "/WEB-INF/Login.jsp";
		    }
	}
}
