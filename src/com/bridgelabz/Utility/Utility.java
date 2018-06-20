package com.bridgelabz.Utility;

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

}
