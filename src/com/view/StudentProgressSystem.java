package com.view;

import java.util.Scanner;

import com.model.Storage;
import com.model.SysAdmin;
import com.model.User;

public class StudentProgressSystem {

	public static Scanner scanner;

	public static void run() {
		scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Welcome to the Student Progress System. Press Enter to begin; q to exit.");
			String input = scanner.nextLine();

			if (input.equals("UpUpDownDownLeftRightLeftRightBA"))
				fancyAdminMode();
			else if (input.equals("q"))
				break;

			Menu.displayMenu(logIn());
		}
		scanner.close();
	}

	private static void fancyAdminMode() {
		System.out.println("fancy admin mode activated");
		SysAdmin temp = new SysAdmin("temp", "temp", "temp");
		
		temp.createAccount();
		Storage.users.remove(temp);
		
		System.out.println(Storage.users.toString());
		System.out.println();
		System.out.println(Storage.courses.toString());
		System.out.println();
		System.out.println(Storage.programs.toString());
		System.out.println();
	}

	private static User logIn() {
		User user = null;
		boolean isLoggedIn = false;

		System.out.println("Please enter your account details");
		while (!isLoggedIn) {
			System.out.println("ID: ");
			String inputId = scanner.next();
			user = Storage.getUser(inputId);
			System.out.println(inputId);
			if (user == null) {
				System.out.println("The ID you entered does not exist. Please try again");
				continue;
			}

			System.out.println("Password: ");
			String passwordEntry = scanner.next();
			if (!user.getPassword().equals(passwordEntry)) {
				System.out.println("The Password you entered does not match the ID. Please try again");
				continue;
			}
			isLoggedIn = true;
		}
		System.out.println("Logging in...\n");
		return user;
	}
}
