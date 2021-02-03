package com.cg.healthify.main;

import java.util.Scanner;

import com.cg.healthify.exceptions.NoRecordFoundException;
import com.cg.healthify.pojo.Customer;
import com.cg.healthify.pojo.Login;
import com.cg.healthify.services.CustomerServiceImpl;

public class LoginMenu {
	CustomerServiceImpl custimpl = new CustomerServiceImpl();
	Scanner sc = new Scanner(System.in);
	String ContChoice;
	CustomerMenu cMenu = new CustomerMenu();
	Customer cust = new Customer();
	Login login = new Login();

	void menu() {
		System.out.println("1. NEW USER");
		System.out.println("2. EXISTING USER");
	}

	public void loginMenu()  {
		menu();

		System.out.println("Enter the Choice: ");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			cMenu.add();
	
			break;
	       case 2:
			        //custimpl.loginAuthentication();
				EntityManager em=SameUtilContainer.emf.createEntityManager();
				System.out.println("Enter your ID:");
				int ini=sc.nextInt();
				System.out.println("Enter Password:");
				String password=sc.next();
				int io=0;

				Query query=em.createQuery("from Login");
				List<Login> loginm= query.getResultList();
				for(Login i:loginm) {
					if(i.getId()==ini && i.getPassword().equals(password)) {
						io++;
						break;
					}
				}
				if(io==0) {
					System.out.println("Invalid User!!");
				}
				else {
					MainMenu mains=new MainMenu();
					mains.main_menu();		  
				}
				break;
		default:
			System.exit(0);
			break;
		}

	}

}
