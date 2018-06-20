package com.bridgelabz.serviceimplementation;

import com.bridgelabz.Utility.Utility;
import com.bridgelabz.databaseaccessobject.DatabaseAccessObject;
import com.bridgelabz.model.User;
import com.bridgelabz.service.Services;

public class ServiceImplementations implements Services{
  User user=new User();
  DatabaseAccessObject object=new DatabaseAccessObject();
	@Override
	public void register() {
		
	System.out.println("Enter the name");
	user.setUserName(Utility.userInputString());
	System.out.println("enter the email");
	user.setEmail(Utility.userInputString());
	System.out.println("enter the phone number");
	user.setPhonenum(Utility.userInputInteger());
	System.out.println("enter the passward");
	user.setPassward(Utility.userInputString());
	System.out.println("registration successfull");
	object.getConnection();
	object.register(user);
	DatabaseAccessObject.closeconnection();

	}

	@Override
	public void login(String email, String passward) {
		user.setEmail(email);
		user.setPassward(passward);
		object.getConnection();
		user=DatabaseAccessObject.login(email,passward);
		DatabaseAccessObject.closeconnection();
		System.out.println(user.toString());
		
	}
}
