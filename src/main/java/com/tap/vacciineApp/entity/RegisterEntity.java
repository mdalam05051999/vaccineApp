package com.tap.vacciineApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "register_table")
public class RegisterEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "REGISTER_ID")
	private int ID;
	
	@Column(name = "REGISTER_USERNAME")
	private String username;
	
	@Column(name = "REGISTER_EMAIL")
	private String email;
	
	@Column(name = "REGISTER_PASSWORD")
	private String password;
	
	@Column(name = "REGISTER_MOBILE_NUMBER")
	private String mobileNumber;
	
	@Column(name = "REGISTER_GENDER")
	private String gender;
	
	@Column(name = "REGISTER_DOB")
	private String dateOfBirth;
	
	@Column(name = "LOGIN_ATTEMPT")
	private int loginAttempt;
	
	@Column(name = "MEMEBER_COUNT")
	private int memberCount;
	
	public RegisterEntity() {
		// TODO Auto-generated constructor stub
	}
	
	

	public RegisterEntity(String username, String email, String password, String mobileNumber, String gender,
			String dateOfBirth) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
	}



	public RegisterEntity(int iD, String username, String email, String password, String mobileNumber, String gender,
			String dateOfBirth) {
		super();
		ID = iD;
		this.username = username;
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getLoginAttempt() {
		return loginAttempt;
	}



	public void setLoginAttempt(int loginAttempt) {
		this.loginAttempt = loginAttempt;
	}
	
	



	public int getMemberCount() {
		return memberCount;
	}



	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}



	@Override
	public String toString() {
		return "RegisterEntity [ID=" + ID + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", mobileNumber=" + mobileNumber + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth
				+ ", loginAttempt=" + loginAttempt + ", memberCount=" + memberCount + "]";
	}
	
	

}
