package com.tap.vacciineApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vacciineApp.dao.RessetPasswordDAO;

@Component
public class ResetPasswordService {
	public ResetPasswordService() {
		System.out.println("ResetPasswordService is invoked");
	}
	
	private RessetPasswordDAO ressetPasswordDAO;
	@Autowired
	protected ResetPasswordService(RessetPasswordDAO ressetPasswordDAO) {
		super();
		this.ressetPasswordDAO = ressetPasswordDAO;
	}

	public boolean validateResetPsssword(String email, String password) {
		boolean flag = true;
		String usernameRegex = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
		String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,16}$";

		if (email == "" || email.isBlank() || email.isEmpty() || !email.matches(usernameRegex)) {
			flag = false;
			System.out.println("username is invalid");
		}
		if (password == "" || password.isBlank() || password.isEmpty() || !password.matches(passwordRegex)) {
			flag = false;
			System.out.println("password is invalid");
		}
		
		if (flag) {
			boolean resetPasswordByEmail = ressetPasswordDAO.resetPasswordByEmail(email, password);
			System.out.println("password has been reset");
			return resetPasswordByEmail;
		}

		return flag;

	}

}
