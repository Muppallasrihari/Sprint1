package com.cg.healthify.services;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.cg.healthyfy.daos.CustomerDAO;
import com.cg.healthyfy.daos.CustomerDAOImpl;
import com.cg.healthyfy.domain.Customer;
import com.cg.healthyfy.domain.Login;
import com.cg.healthyfy.exceptions.NoRecordFoundException;
import com.cg.healthyfy.menu.MainMenu;
import com.cg.healthyfy.util.SameUtilContainer;



public class CustomerServiceImpl implements CustomerService{
	CustomerDAO custdao;
	EntityManager em=SameUtilContainer.emf.createEntityManager();


	public CustomerServiceImpl() {
		custdao=new CustomerDAOImpl();
	}
	Login login=new Login();

	public Customer adduser(Customer cust) {
		custdao.saveCustomerDetail(cust);
		return cust;
	}
	public Customer updateuser(Customer cust){
		int io1=0;
		int ini=cust.getId();
		try {
			Query query=em.createQuery("from Customer");
			List<Customer> customer= query.getResultList();
			for(Customer i:customer) {
				if(i.getId()==ini) {
					io1++;
					break;
				}
			}  
			Validate(io1);
		}
		catch(NoRecordFoundException m) {
			System.out.println(m);
		}if(io1==1) {
			return custdao.updateCustomerDetails(cust);
		}
		return cust;}
	public int deleteUser(int id){
		int io1=0;
		int ini=id;
		try {
			Query query=em.createQuery("from Customer");
			List<Customer> customer= query.getResultList();
			for(Customer i:customer) {
				if(i.getId()==ini) {
					io1++;
					break;
				}
			}  
			Validate(io1);
		}
		catch(NoRecordFoundException m) {
			System.out.println(m);
		}if(io1==1) {
			custdao.cancelPlan(ini);
		}
		return io1;
	}
	@Override
	public List<Customer> findAll() {
		custdao.findAll();
		return null;
	}
	@Override
	public int findUser(int i)throws NoRecordFoundException{
		int io1=0;
		try {
			Query query=em.createQuery("from Customer");
			List<Customer> customer= query.getResultList();
			for(Customer ii:customer) {
				if(ii.getId()==i) {
					io1++;
					break;
				}
			}  
			Validate(io1);
		}
		catch(NoRecordFoundException m) {
			System.out.println(m);
		}if(io1==1) {
			custdao.findByUser(i);
		}
		return io1;
	}

	static void Validate(int io)throws NoRecordFoundException{
		if(io==0) {
			throw new NoRecordFoundException("No Records Found");
		}
	}

	public void loginAuthentication() throws NoRecordFoundException {
		Scanner sc=new Scanner(System.in);
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
	}
}

