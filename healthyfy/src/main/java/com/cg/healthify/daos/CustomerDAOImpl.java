package com.cg.healthify.daos;

import java.util.List;

import javax.persistence.Query;

import com.cg.healthify.exceptions.NoRecordFoundException;
import com.cg.healthify.pojo.Customer;
import com.cg.healthify.pojo.Login;
import com.cg.healthify.util.DBUtil;

public class CustomerDAOImpl extends DBUtil implements CustomerDAO {

	@Override
	public Customer saveCustomer(Customer cust) {
		Login login=new Login();	
		  em.getTransaction().begin();
	      em.persist(cust);
	      login.setId(cust.getId());
		  login.setPassword(cust.getName()+cust.getId());
	      em.persist(login);
	      System.out.println("Welcome Our New User: "+cust.getName()+"\nYour LoginId is: "+login.getId()+"\nYour Password is: "+login.getPassword());
	      em.getTransaction().commit();
	      return cust;
	}

	@Override
	public Customer updateCustomer(Customer cust) {
		String newContact = cust.getContact();
		String newMedical = cust.getMedicalCondition();
		String newAllergic = cust.getAllergicTo();
		em.getTransaction().begin();
		cust = em.find(Customer.class, cust.getId());
		cust.setContact(newContact);
		cust.setMedicalCondition(newMedical);
		cust.setAllergicTo(newAllergic);
		em.persist(cust);
		System.out.println("Your Details Are Updated....");
		em.getTransaction().commit();
		return cust;
	}

	@Override
	public Customer cancelPlan(Customer cust) throws NoRecordFoundException {
		em.getTransaction().begin();
		cust = em.find(Customer.class, cust.getId());
		em.remove(cust);
		// em.remove(log);
		System.out.println("Your Plan is Cancelled");
		em.getTransaction().commit();
		return cust;
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from Customer");
		@SuppressWarnings("unchecked")
		List<Customer> list = (List<Customer>) query.getResultList();
		for (Customer c : list) {
			System.out.println("Customer ID: " + c.getId());
			System.out.println("Name: " + c.getName());
			System.out.println("Gender: " + c.getGender());
			System.out.println("Date Of Birth: " + c.getDob());
			System.out.println("Contact Number:" + c.getContact());
			System.out.println("Medical Condition: " + c.getMedicalCondition() + "\nAllergy To: " + c.getAllergicTo());
			System.out.println("\n");
		}
		return list;
	}

	@Override
	public Customer findByUser(int i) throws NoRecordFoundException {
		// TODO Auto-generated method stub
		Customer cust = new Customer();
		cust = em.find(Customer.class, i);
		em.getTransaction().begin();
		System.out.println("Customer ID: " + cust.getId());
		System.out.println("Name: " + cust.getName());
		System.out.println("Gender: " + cust.getGender());
		System.out.println("Date Of Birth: " + cust.getDob());
		System.out.println("Contact Number:" + cust.getContact());
		System.out
				.println("Medical Condition: " + cust.getMedicalCondition() + "\nAllergy To: " + cust.getAllergicTo());
		em.getTransaction().commit();
		return cust;
	}

	

}
