package com.tap.vacciineApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.tap.vacciineApp.dao.RegisterDAO;
import com.tap.vacciineApp.entity.RegisterEntity;

@Component
public class RegisterService {
	public RegisterService() {
		// TODO Auto-generated constructor stub
	}

	private RegisterDAO registerDAO;
	@Autowired
	protected RegisterService(RegisterDAO registerDAO) {
		super();
		this.registerDAO = registerDAO;
	}

	public boolean validateRegister(String username, String email, String password, String mobileNumber, String gender,
			String dob) {
		boolean flag = true;
		String usernameRegex = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
		String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,16}$";
		String mobNoRegex = "^[0-9]{10}$";

		if (username == "" || username.isBlank() || username.isEmpty() || !username.matches(usernameRegex)) {
			flag = false;
			System.out.println("username is invalid");
		}

		if (email == "" || email.isBlank() || email.isEmpty() || !email.matches(usernameRegex)) {
			flag = false;
			System.out.println("email is invalid");
		}

		if (password == "" || password.isBlank() || password.isEmpty() || !password.matches(passwordRegex)) {
			flag = false;
			System.out.println("password is invalid");
		}

		if (mobileNumber == "" || mobileNumber.isBlank() || mobileNumber.isEmpty()
				|| !mobileNumber.matches(mobNoRegex)) {
			flag = false;
			System.out.println("mobileNumber is invalid");
		}

		if (gender == "" || gender.isBlank() || gender.isEmpty()) {
			flag = false;
			System.out.println("gender is invalid");
		}

		if (dob == "" || dob.isBlank() || dob.isEmpty()) {
			flag = false;
			System.out.println("dob is invalid");
		}
		if (flag) {
			RegisterEntity entity = new RegisterEntity(username, email, password, mobileNumber, gender, dob);
			boolean isDataSaved = registerDAO.saveRegisterEntity(entity);
			System.out.println("Entity has been saved");
			return isDataSaved;
		}
		return flag;
	}
}
