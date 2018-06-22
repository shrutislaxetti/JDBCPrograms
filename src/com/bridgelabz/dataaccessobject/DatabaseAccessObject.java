package com.bridgelabz.dataaccessobject;

import com.bridgelabz.model.User;

public interface DatabaseAccessObject {
	public void register(User user);
	public void getConnection();
	public User login(String email, String passward);
	public void closeconnection();
}
