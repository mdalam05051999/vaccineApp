package com.tap.vacciineApp.dao;

import com.tap.vacciineApp.entity.RegisterEntity;

public interface LoginDAO {
	RegisterEntity getRegisterEntityByEmail(String email);
	int increaseLoginAttepmt(String email,int loginAttemptcount);

}
