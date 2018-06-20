package com.bridgelabz.service;

import java.sql.SQLException;

public interface Services {
	
	public void register();

	public void login(String name, String passward) throws SQLException;

}
