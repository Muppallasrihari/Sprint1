package com.cg.healthify.main;

import java.util.Scanner;

import com.cg.healthify.services.CustomerServiceImpl;
import com.cg.healthify.services.NutritionServiceImpl;

public class NutritionMenu {

		Scanner sc = new Scanner(System.in);
		String ContChoice;
		NutritionServiceImpl nutimpl = new NutritionServiceImpl();

		void menu() {
			System.out.println("1. ADD THE NUTRITION PLAN");
			System.out.println("2. DELETE THE PLAN");
			System.out.println("3. UPDATE THE PLAN");
			System.out.println("4. SHOW ALL THE PLANS");
			System.out.println("5. EXIT");
		}

		public void nutritionMenu() {
	//menu();
			do {
				System.out.println("Enter the Choice: ");
				menu();
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
				/*	System.out.println("Enter your ID: ");
					nutrition.setId(sc.nextInt());
					System.out.println("Enter the Name: ");
					nutrition.setName(sc.next());
					System.out.println("Enter the plan description: ");
					nutrition.setPlandescription(sc.next());
					System.out.println("Enter the Price:");
					nutrition.setPrice(sc.nextInt());
					nutimpl.addNutrition();*/
					break;
				case 2:
					nutimpl.deleteNutrition();
					break;
				case 3:
					nutimpl.updateNutrition();
					break;
				case 4:
					nutimpl.findNutritionData();
					break;
				case 5:
					System.exit(0);
					break;	
				default:
					System.exit(0);
				}
				System.out.println("Want to Continue as user.");
				ContChoice = sc.next();
			} while (ContChoice.equalsIgnoreCase("Y"));
		}
	}

