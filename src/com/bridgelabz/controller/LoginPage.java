package com.bridgelabz.controller;

import java.sql.SQLException;

import com.bridgelabz.Utility.Utility;
import com.bridgelabz.service.Services;
import com.bridgelabz.serviceimplementation.ServiceImplementations;

public class LoginPage {
	public static void main(String[] args) throws SQLException {
		Services service=new ServiceImplementations();
		System.out.println("enter 1 to Register");
		System.out.println("enter 2 to login");
		System.out.println("enter your choice");
		int choice = Utility.userInputInteger();
		switch (choice) {
		case 1:
			service.register();
			break;
		case 2:
			System.out.println("enter email");
			String email=Utility.userInputString();
			System.out.println("enter passward");
			String passward=Utility.userInputString();
			service.login(email,passward);
			break;
		default:
			System.out.println("enter wrong choice...");
			break;
		}
	}
}
