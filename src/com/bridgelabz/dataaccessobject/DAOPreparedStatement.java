package com.bridgelabz.dataaccessobject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.model.User;

public class DAOPreparedStatement implements DatabaseAccessObject {
	User user = new User();
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet rs = null;
	String url = "jdbc:mysql://localhost:3306?user=root&password=root";

	/**
	 * function to get the connction which loads and register the driver
	 */
	public void getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("deriver class loaded and registered");
			connection = DriverManager.getConnection(url);
			System.out.println("connecton established");

		} catch (Exception e) {
			System.out.println("failed to establish connection");
		}

	}

	/**
	 * function to register the user int the database
	 * 
	 * @param name
	 * @param id
	 * @param phonenumber
	 * @param email
	 */
	public void register(User user) {

		String query = "SELECT * FROM user_database.user where email=?";
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, user.getEmail());
			rs = statement.executeQuery();
			if (rs.next()) {
				if (rs.getString(2).equals(user.getEmail())) {
					System.out.println("you have been already registered...");
				}
			} else {
				System.out.println("..........");
				String query1 = "insert into user_database.user(username,email,phone,passward) values(?,?,?,?)";
				statement = connection.prepareStatement(query1);
				statement.setString(1, user.getUserName());
				statement.setString(2, user.getEmail());
				statement.setInt(3, user.getPhonenum());
				statement.setString(4, user.getPassward());
				statement.executeUpdate();
			}

		} catch (Exception e) {
			System.out.println("failed");
			e.printStackTrace();
		}

	}

	/**
	 * function to login the user
	 * 
	 * @param email
	 * @param passward
	 */
	public User login(String email, String passward) {
		String query = "SELECT * FROM user_database.user where email=? AND passward=? ";
		try {

			statement = connection.prepareStatement(query);
			System.out.println("/////");
			statement.setString(1, email);
			statement.setString(2, passward);
			rs = statement.executeQuery();

			if (rs.next()) {
				user.setUserName(rs.getString(1));
				user.setEmail(rs.getString(2));
				user.setPhonenum(rs.getInt(3));
				user.setPassward(rs.getString(4));
				System.out.println("................");
			} else {
				System.out.println("invalid");
			}

		} catch (Exception e) {
			System.out.println("prepared statement is not created");
		}
		return user;

	}

	/**
	 * function to close all costly resourses
	 */
	public void closeconnection() {
		if (rs != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}
}
