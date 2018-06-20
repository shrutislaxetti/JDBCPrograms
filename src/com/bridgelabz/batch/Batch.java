package com.bridgelabz.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridgelabz.utility.Utility;

public class Batch {

public static void main(String[] args) {
	Connection connection=null;
	Statement statement=null;
	
	String driver=Utility.getproperty("Driver");
	String user=Utility.getproperty("user");
	String passward=Utility.getproperty("password");
	
	String query2="insert into Student.Employee (Employee_id,Employee_Name,Employee_Salary) values(0,'shruti',5000)";
	String query3="insert into Student.Employee (Employee_id,Employee_Name,Employee_Salary) values(0,'simran',10000)";
	String query4="update Student.Employee set Employee_Salary=8000 where Employee_id=1";
	//String query5="update Student.Employee set salary='20000' where empid=2";
	String query6="delete from Student.Employee  where Employee_id=1";
	
	try {
        Class.forName(driver);
        
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306?user="+user+"&password="+passward);
		System.out.println("connection established");
		
		statement=connection.createStatement();
		statement.addBatch(query2);
		statement.addBatch(query3);
		statement.addBatch(query4);
		//statement.addBatch(query5);
		statement.addBatch(query6);
		connection.setAutoCommit(false);
		int [] array=statement.executeBatch();
		for(int a:array) {
			System.out.println(a);
		}
		System.out.println();
		
		connection.commit();	
    }
	catch(Exception e) {
			e.printStackTrace();
			System.out.println("failed ...");
	}
finally {

   if(statement!=null) {
	try {
		statement.close();
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

   
   
   