package com.cg.healthify.main;

import java.util.Scanner;

import com.cg.healthify.pojo.Exercise;
import com.cg.healthify.services.ExerciseServiceImpl;

public class ExerciseMenu {
	Scanner sc = new Scanner(System.in);
	Exercise exercise = new Exercise();
	String ContChoice;
	ExerciseServiceImpl exerciseimpl = new ExerciseServiceImpl();

	void menu() {
		System.out.println("1. ADD THE EXERCISE PLAN");
		System.out.println("2. DELETE THE PLAN");
		System.out.println("3. UPDATE THE PLAN");
		System.out.println("4. SHOW ALL THE PLANS");
		System.out.println("5. EXIT");
	}

	public void exerciseMenu() {
//menu();
		do {
			System.out.println("Enter the Choice: ");
			menu();
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter your ID: ");
				exercise.setId(sc.nextInt());
				System.out.println("Enter the Exercise type: ");
				exercise.setExerciseType(sc.next());
				System.out.println("Enter the exercise plan : ");
				exercise.setExercisePlan(sc.next());
				exerciseimpl.addExercise(exercise);
				break;
			case 2:
				System.out.println("Please Confirm your Id to remove your exercise plan: ");
				exercise.setId(sc.nextInt());
				exerciseimpl.deleteExercise(exercise);
				break;
			case 3:
				System.out.println("Please Confirm your ID to update Exercise plan ");
				exercise.setId(sc.nextInt());
				System.out.println("Enter the Exercise type: ");
				exercise.setExerciseType(sc.next());
				System.out.println("Enter the exercise plan : ");
				exercise.setExercisePlan(sc.next());
				exerciseimpl.updateExercise(exercise);
				break;
			case 4:
				System.out.println("Please give your ID to get your exercise details: ");
				exercise.setId(sc.nextInt());
				exerciseimpl.findExerciseData(exercise);
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
