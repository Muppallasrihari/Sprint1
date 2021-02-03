package com.cg.healthify.main;

import java.util.Scanner;

import com.cg.healthify.pojo.Customer;
import com.cg.healthify.pojo.Login;
import com.cg.healthify.services.CustomerServiceImpl;

public class CustomerMenu {
	Scanner sc = new Scanner(System.in);
	String contChoice;
	Customer cust = new Customer();
	Login login = new Login();
	CustomerServiceImpl custimpl = new CustomerServiceImpl();

	public  void add() {
		System.out.println("-------A Warm Welcome To Our New Customer---------");
		System.out.println("Enter Your Name: ");
		cust.setName(sc.next());
		sc.nextLine();
		System.out.println("Enter Your Gender: ");
		cust.setGender(sc.next());
		sc.nextLine();
		System.out.println("Enter Your Date of Birth: ");
		cust.setDob(sc.next());
		System.out.println("Enter Your Contact: ");
		cust.setContact(sc.next());
		System.out.println("Any Medical Condition: ");
		cust.setMedicalCondition(sc.next());
		sc.nextLine();
		System.out.println("Any Allergy: ");
		cust.setAllergicTo(sc.next());
		custimpl.addUser(cust);
	}

	public void customerMenu() {
		do {
			showMenu();
			System.out.println("Enter Your Choice");
			int choice = sc.nextInt();
			switch (choice) {

			case 1:
				System.out.println("Please Confirm ID to Update your Details: ");
				cust.setId(sc.nextInt());
				System.out.println("Enter your new Contact:");
				cust.setContact(sc.next());
				sc.nextLine();
				System.out.println("Current Medical Condition: ");
				cust.setMedicalCondition(sc.next());
				System.out.println("New Allergy: ");
				cust.setAllergicTo(sc.next());
				custimpl.updateUser(cust);
				break;
			case 2:
				System.out.println("Please Confirm your Id to delete : ");
				cust.setId(sc.nextInt());
				custimpl.deleteUser(cust);
				break;
			case 3:
				System.out.println("Please give your ID to find your details: ");
				cust.setId(sc.nextInt());
				custimpl.findUser(cust.getId());
				break;
			case 4:
				custimpl.findAll();
				break;

			case 5:
				System.exit(0);

			default:
				System.out.println("Wrong Choice");
				break;

			}
			System.out.println("Wants to continue with customer menu: ");
			contChoice = sc.next();
		} while (contChoice.equalsIgnoreCase("Y"));
	}

	void showMenu() {
		System.out.println("---------HEALTHYAPP CUSTOMER MENU-----------");
		System.out.println("1. Update Existing Customer");
		System.out.println("2. Delete Existing Customer");
		System.out.println("3. Find Specific Customer Details");
		System.out.println("4. Display All Customers");
		System.out.println("5. Exit");
	}
}