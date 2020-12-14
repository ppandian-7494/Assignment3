package com.iptech;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Assignment3 {
	public static User[] users = new User[4];
	private static UserService userService = new UserService();

	public static void maiten(String[] args) throws IOException {
		populateUserArray();
		
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);

			boolean validLogin = false;
			int numberOfLoginAttempts = 0;
			while (!validLogin && numberOfLoginAttempts < 5) {
				
				System.out.println("Enter your email:");
				String username = scanner.nextLine();
				System.out.println("Enter your password: ");
				String password = scanner.nextLine();

				User validUser = userService.isValidUser(username, password);
				if (validUser != null) {
					System.out.println("Welcome: " + validUser.getName());
					validLogin = true;
				} else {
					System.out.println("Invalid login, please try again");
					numberOfLoginAttempts++;
					if (numberOfLoginAttempts >= 5) {
						System.out.println("Too many failed login attempts, you are now locked out.");
					}
				}
			}
		} finally {
			if (scanner != null) 
				scanner.close();
		}
	}
	
	private static void populateUserArray() throws FileNotFoundException, IOException {
		String fileName = "user-data.txt";
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
			String line = null;
			int i = 0;
			while((line = br.readLine()) != null) {
				users[i] = new User(line.split(","));
				i++;
			}
		} finally {
			if (br != null) br.close();
		}
	}

}
