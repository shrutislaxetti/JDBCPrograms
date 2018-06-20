package com.bridgelabz.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import com.bridgelabz.utility.Utility;

public class JdbcTransaction {

public static void main(String[] args) {
	
	Connection connection=null;
	PreparedStatement pstmt1=null;
	PreparedStatement pstmt2=null;
	Savepoint save=null;
	String studentedu="insert into  Student.Eduction values(?,?,?,?,?)";
	String studentper="insert into  Student.Personal values(?,?,?)";
	
	int id=0;
	System.out.println("enter the student name");
	String name=Utility.userInputString();
	System.out.println("Enter the department");
	String dept=Utility.userInputString();
	System.out.println("enter the percentage");
	String percentage=Utility.userInputString();
	System.out.println("enter place");
	String place=Utility.userInputString();
	try {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
		
		System.out.println("connection established");
		connection.setAutoCommit(false);
		
		pstmt1=connection.prepareStatement(studentedu);
		pstmt1.setInt( 1,id);
		pstmt1.setString(2, name);
		pstmt1.setString(3,dept);
		pstmt1.setString(4, percentage);
		pstmt1.setString(5, place);
		pstmt1.executeUpdate();
		connection.commit();
		
		System.out.println("student educational details executed");
		save=connection.setSavepoint();
		
		pstmt2=connection.prepareStatement(studentper);
		pstmt2.setInt(1, id);
		pstmt2.setString(2, name);
		pstmt2.setString(3, place);
		pstmt2.executeUpdate();
		connection.commit();
		
		System.out.println("student personal detalis executed");
		
	}
	catch(Exception e) {
		try {
			connection.rollback(save);
			connection.commit();
			System.out.println("operation is roll back");
		}
		catch(SQLException e1) {
			
			System.out.println("failed ...");
		}
		e.printStackTrace();
	}
 
finally {
if(pstmt2!=null) {
	try {
		pstmt2.close();
	}
	catch(SQLException e1) {
		
		e1.printStackTrace();
	}
}
   if(pstmt1!=null) {
	try {
		pstmt1.close();
	}
	catch(SQLException e1) {
		
		e1.printStackTrace();
	}
   }
   if(connection!=null) {
	try {
		connection.close();
	}
	catch(SQLException e1) {
		
		e1.printStackTrace();
	}
}
}

}
}