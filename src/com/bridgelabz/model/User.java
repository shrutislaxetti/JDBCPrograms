package com.bridgelabz.model;

public class User {
	private String userName;
	private String email;
	private int phonenum;
	@Override
	public String toString() {
		return "User [userName=" + userName + ", email=" + email + ", phonenum=" + phonenum + ", passward=" + passward
				+ "]";
	}

	private String passward;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(int phonenum) {
		this.phonenum = phonenum;
	}

	public String getPassward() {
		return passward;
	}

	public void setPassward(String passward) {
		this.passward = passward;
	}

}
