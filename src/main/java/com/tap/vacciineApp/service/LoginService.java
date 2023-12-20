package com.tap.vacciineApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.tap.vacciineApp.dao.LoginDAO;
import com.tap.vacciineApp.entity.RegisterEntity;

@Component
public class LoginService {

	public LoginService() {
		System.out.println("LoginService is invoked");
	}
	
	private static final int maxLoginAttempt = 2;

	private LoginDAO loginDAO;
	private JavaMailSenderImpl javaMailSenderImpl;

	@Autowired
	protected LoginService(LoginDAO loginDAO, JavaMailSenderImpl javaMailSenderImpl) {
		super();
		this.loginDAO = loginDAO;
		this.javaMailSenderImpl = javaMailSenderImpl;
	}

	public boolean validateLogin(String email, String password) {
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

		return flag;

	}

	public RegisterEntity getRegisterEntityByEmail(String email) {
		return loginDAO.getRegisterEntityByEmail(email);
	}

	public boolean loginDetailsCheck(String email, String password) {
		boolean flag = true;
		RegisterEntity userEntity = loginDAO.getRegisterEntityByEmail(email);

		if (userEntity == null) {
			flag = false;
			System.out.println("User not found");
		} else {
			String Username = userEntity.getEmail();
			String Password = userEntity.getPassword();
			int loginAttempt = userEntity.getLoginAttempt();

			System.out.println(Username);
			System.out.println(Password);
			System.out.println(userEntity.getLoginAttempt());

			if (loginAttempt > maxLoginAttempt) {
				flag = false;
				System.out.println("Your account is blocked due to too many failed login attempts.");
				String toMail = userEntity.getEmail();
				String subject = "Vaccine App Account Blocked";
				String body = "Dear " + userEntity.getEmail() + "\n"
						+ "We are Writing to inform you that Your Account at Vaccine App has been Temporarily"
						+ "Locked Due to multiple unsuccessfull login Attempts.\n"
						+ "Multiple unsuccessful login Attempts were Detected on your Account. This May be due to entring an incorrect paasword several times.\n"
						+ "To Unlock your account please follow these Stetps:\r\n"
						+ "1. Visit our login page : http://localhost:8080/vacciineApp/gotoLoginPage\r\n"
						+ "2.Click on the \"Forgot Password\" link.\r\n"
						+ "Follow the instructions to Reset your password.";
				SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
				simpleMailMessage.setTo(toMail);
				simpleMailMessage.setSubject(subject);
				simpleMailMessage.setText(body);

				javaMailSenderImpl.send(simpleMailMessage);

				System.out.println("Account Blocked Mail sent.");

			} else {
				if (!Username.equals(email)) {
					flag = false;
					System.out.println("Wrong Username");
				}
				if (!Password.equals(password)) {
					flag = false;
					System.out.println("Wrong Password");
					loginDAO.increaseLoginAttepmt(email, loginAttempt);
					System.out.println("You have attempted " + loginAttempt + " times.");
				}
			}
		}

		return flag;

	}

}
