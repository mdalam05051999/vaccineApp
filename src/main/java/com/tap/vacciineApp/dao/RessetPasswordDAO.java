package com.tap.vacciineApp.dao;

public interface RessetPasswordDAO {
	boolean resetPasswordByEmail(String email,String newPassword);

}
