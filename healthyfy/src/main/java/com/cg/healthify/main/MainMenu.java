package com.cg.healthify.main;

import java.util.Scanner;

public class MainMenu {
	Scanner sc = new Scanner(System.in);
	String ContChoice;

	void menu() {
		System.out.println("1. CUSTOMER");
		System.out.println("2. NUTRITION PLAN");
		System.out.println("3. EXERCISE PLAN");
		System.out.println("4. CALORIES LOG");
		System.out.println("5. WEIGHT-LOG");
		System.out.println("6. DIET-PLAN");
		System.out.println("7. PAYMENT");
	}

	public void mainMenu() {
		menu();
		do {
			System.out.println("Enter the Choice: ");
			int choice = sc.nextInt();
			switch (choice) {

			case 1:
				CustomerMenu custMenu = new CustomerMenu();
				custMenu.customerMenu();
				break;
				
			case 2:
				NutritionMenu nutMenu = new NutritionMenu();
				nutMenu.nutritionMenu();
				break;
				
			case 3:
				ExerciseMenu exerMenu = new ExerciseMenu();
				exerMenu.exerciseMenu();
				break;
				
			case 4:
				CaloriesLogMenu calMenu = new CaloriesLogMenu();
				calMenu.caloriesLogMenu();
				break;
				
			case 5:
				WeightLogMenu wtMenu = new WeightLogMenu();
				wtMenu.weightLogMenu();
				break;
				
			case 6:
				DietMenu menu = new DietMenu();
				menu.dietMenu();
				break;
			case 7:
				PaymentMenu pay = new PaymentMenu();
				pay.payment_menu();
				break;
			default:
				System.out.println("--------------------WRONG-CHOICE--------------------");
				break;
			}
			System.out.println("Wants to Continue with main menu.");
			ContChoice = sc.next();
		} while (ContChoice.equalsIgnoreCase("Y"));
	}

}
