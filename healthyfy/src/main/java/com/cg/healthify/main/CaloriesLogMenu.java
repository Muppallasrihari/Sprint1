package com.cg.healthify.main;

import java.util.Scanner;

import com.cg.healthify.services.CaloriesLogServiceImpl;

public class CaloriesLogMenu {
	Scanner sc = new Scanner(System.in);
	String ContChoice;
	CaloriesLogServiceImpl calories = new CaloriesLogServiceImpl();

	void menu() {
		System.out.println("1. ADD CALORIES LOG");
		System.out.println("2. UPDATE CALORIES LOG");
		System.out.println("3. DELETE CALORIES LOG");
		System.out.println("4. FIND CALORIES LOG");
		System.out.println("5. EXIT");
	}

	public void caloriesLogMenu() {
		// menu();
		do {
			System.out.println("Enter the Choice: ");
			menu();
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				calories.addCaloriesLog();
				break;
			case 2:
				calories.UpdateCaloriesLog();
				break;
			case 3:
				calories.DeleteCaloriesLog();
				break;
			case 4:
				calories.findCaloriesLog();
				break;
			case 5:
				System.exit(0);
				break;
			}
			System.out.println("Wants to continue caloriesLog operation.");
			ContChoice = sc.next();
		} while (ContChoice.equalsIgnoreCase("Y"));
	}
}
