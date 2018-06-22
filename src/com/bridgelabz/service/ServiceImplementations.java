package com.bridgelabz.service;

import com.bridgelabz.dataaccessobject.DatabaseAccessObject;
import com.bridgelabz.factory.LoginValidationFactory;
import com.bridgelabz.model.User;
import com.bridgelabz.utility.Utility;

public class ServiceImplementations implements Service {
	  User user=new User();
	
		@Override
		public void register(User user) {
			
		System.out.println("Enter the name");
		user.setUserName(Utility.userInputString());
		System.out.println("enter the email");
		user.setEmail(Utility.userInputString());
		System.out.println("enter the phone number");
		user.setPhonenum(Utility.userInputInteger());
		System.out.println("enter the passward");
		user.setPassward(Utility.userInputString());
		System.out.println("enter the type of Statement you want to execute");
		String type = Utility.userInputString();
		
		DatabaseAccessObject objectref = LoginValidationFactory.getdao(type);

		objectref.getConnection();
		objectref.register(user);
		objectref.closeconnection();

		}

		@Override
		public void login(String email, String passward) {
			user.setEmail(email);
			user.setPassward(passward);
			System.out.println("enter the type of Statement you want to execute");
			String type = Utility.userInputString();
			DatabaseAccessObject objectref = LoginValidationFactory.getdao(type);
            System.out.println(objectref);
			objectref.getConnection();
			user=objectref.login(email,passward);
			objectref.closeconnection();
			System.out.println(user.toString());
			
		}
	}

