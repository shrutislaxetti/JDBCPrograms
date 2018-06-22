package com.bridgelabz.factory;

import com.bridgelabz.dataaccessobject.DAOPreparedStatement;
import com.bridgelabz.dataaccessobject.DatabaseAccessObject;
import com.bridgelabz.dataaccessobject.DatabaseAccessObjectImplementation;

public class LoginValidationFactory {

	public static  DatabaseAccessObject getdao(String type) {
		
		if(type.equalsIgnoreCase("statement")) {
			
			return new DatabaseAccessObjectImplementation();	
		}
		else if(type.equalsIgnoreCase("preparedstatement")) {
			return new DAOPreparedStatement();
		}
		else {
			System.out.println("invalid input");
		}
		return null;
	}
}
