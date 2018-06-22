package com.bridgelabz.controller;

import java.sql.SQLException;

import com.bridgelabz.model.User;
import com.bridgelabz.service.Service;
import com.bridgelabz.service.ServiceImplementations;
import com.bridgelabz.utility.Utility;

public class LoginPage {

	public static void main(String[] args) throws SQLException {
		Service service = new ServiceImplementations();
		User user=new User();
	while(true) {
			System.out.println("enter 1 to Register");
			System.out.println("enter 2 to login");
			System.out.println("enter 3 to exit");

			System.out.println("enter your choice");
			int choice = Utility.userInputInteger();
			switch (choice) {
			case 1:
				service.register(user);
				break;
			case 2:
				System.out.println("enter email");
				String email = Utility.userInputString();
				System.out.println("enter passward");
				String passward = Utility.userInputString();
				
				service.login(email, passward);
				break;
			case 3:
				System.exit(0);

			default:
				System.out.println("enter wrong choice...");
				break;
			}
		}
	}
}
