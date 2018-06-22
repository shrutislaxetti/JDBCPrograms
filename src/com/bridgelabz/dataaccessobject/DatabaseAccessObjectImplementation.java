package com.bridgelabz.dataaccessobject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridgelabz.model.User;

public class DatabaseAccessObjectImplementation implements DatabaseAccessObject {
	User user = new User();
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
	String url = "jdbc:mysql://localhost:3306?user=root&password=root";

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

	public void register(User user) {

		String query = "SELECT * FROM user_database.user where email='" + user.getEmail() + "';";
		try {
			System.out.println("0");
			statement = connection.createStatement();
			System.out.println("1");
			rs = statement.executeQuery(query);
			System.out.println("3");
			if (rs.next()) {
				if (rs.getString(2).equals(user.getEmail())) {
					System.out.println("you have been already registered...");
				}
			} else {

				String query1 = "insert into user_database.user values('" + user.getUserName() + "','" + user.getEmail()
						+ "'," + user.getPhonenum() + ",'" + user.getPassward() + "');";

				statement.executeUpdate(query1);
			}

		} catch (Exception e) {
			System.out.println("failed");
			e.printStackTrace();
		}

	}

	public User login(String email, String passward) {
		String query1 = "SELECT * FROM user_database.user where email=email AND passward=passward ";
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery(query1);
			if (rs.next()) {
				user.setUserName(rs.getString(1));
				user.setEmail(rs.getString(2));
				user.setPhonenum(rs.getInt(3));
				user.setPassward(rs.getString(4));

			} else {
				System.out.println("invalid email or passward...Plz input correct one");
			}

		} catch (Exception e) {
			System.out.println("statement is not created");
		}
		return user;
	}

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
