package com.bridgelabz.service;

import java.sql.SQLException;

import com.bridgelabz.model.User;

public interface Service {
	
	public void register(User user);

	public void login(String email, String passward) throws SQLException;

	

}
