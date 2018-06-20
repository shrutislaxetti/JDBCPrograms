package com.bridgelabz.utility;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Utility {
	private static Scanner scanner = new Scanner(System.in);

	/* To take String inputs from user */
	public static String userInputString() {
		return scanner.next();
	}

	/* To take Boolean inputs from user */
	public static boolean userInputBoolean() {
		return scanner.nextBoolean();
	}

	/* To take Integer inputs from user */
	public static int userInputInteger() {
		return scanner.nextInt();
	}

	public static String userInputNextLine() {
		return scanner.nextLine();
	}

	public static double userInputDouble() {
		return scanner.nextDouble();
	}


	public static String getproperty(String keys) {
		Properties prop = new Properties();
		FileReader input = null;
		String driver=null;
		try {
			input = new FileReader("/home/bridgrlabz/shruthi/BatchProgram/path.properties");
			prop.load(input);
			 driver=prop.getProperty(keys);
		} catch (IOException e) {
			System.out.println("failed to get the path");
		}
		return driver;
	}
}
