package com.cg.healthify.services;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import com.cg.healthify.daos.CustomerDAOImpl;
import com.cg.healthify.exceptions.NoRecordFoundException;
import com.cg.healthify.main.MainMenu;
import com.cg.healthify.pojo.Customer;
import com.cg.healthify.pojo.Login;
import com.cg.healthify.pojo.Payment;
import com.cg.healthify.util.DBUtil;

public class CustomerServiceImpl extends DBUtil implements CustomerService {
	Customer cust = new Customer();
	CustomerDAOImpl daoimpl = new CustomerDAOImpl();
	Login login = new Login();
	Scanner sc = new Scanner(System.in);

	public Customer addUser(Customer cust) {
		daoimpl.saveCustomer(cust);
		return cust;
	}

	public Customer updateUser(Customer cust) {
		/*int io = 0;
		try {
			Query query = em.createQuery("from Customer");
			List<Login> loginm = query.getResultList();
			for (Login i : loginm) {
				if (i.getId() == cust.getId()) {
					io++;
					break;
				}
			}
			Validate(io);
		} catch (NoRecordFoundException m) {
			System.out.println(m);
		}
		if (io == 1) {
			*/
			daoimpl.updateCustomer(cust);
		
		return cust;

	}

	public Customer deleteUser(Customer customer) throws NoRecordFoundException {
		// TODO Auto-generated method stub
		int io = 0;
		try {
			Query query = em.createQuery("from Login");
			List<Login> loginm = query.getResultList();
			for (Login i : loginm) {
				if (i.getId() == cust.getId()) {
					io++;
					break;
				}
			}
			Validate(io);
		} catch (NoRecordFoundException m) {
			System.out.println(m);
		}
		if (io == 1) {
			login.setId(cust.getId());
			daoimpl.cancelPlan(customer);
		}
		return customer;

	}

	public int findUser(int id) throws NoRecordFoundException {
		// TODO Auto-generated method stub
		int io = 0;
		try {
			
			Query query = em.createQuery("from Login");
			List<Login> loginm = query.getResultList();
			for (Login i : loginm) {
				if (i.getId() == cust.getId()) {
					io++;
					break;
				}
			}
			Validate(io);
		} catch (NoRecordFoundException m) {
			System.out.println(m);
		}
		if (io == 1) {
			daoimpl.findByUser(id);
		}
		return id;

	}

	private void Validate(int io) throws NoRecordFoundException {
		if (io == 0) {
			throw new NoRecordFoundException("No Records Found");
		}
	}

	
	public void loginAuthentication(int id, String password) throws NoRecordFoundException {
		
		int io = 0;
		em.getTransaction().begin();
		Query query = em.createQuery("from Login");
		List<Login> loginm = query.getResultList();
		for (Login i : loginm) {
			if (i.getId() == id && i.getPassword().equals(password)) {
				io++;
				break;
			}
		}
		if (io == 0) {
			System.out.println("Invalid User!!");
		} else {
			MainMenu main = new MainMenu();
			em.getTransaction().commit();
			main.mainMenu();

		}
	}

	

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		daoimpl.findAll();
		return null;
	}

}
