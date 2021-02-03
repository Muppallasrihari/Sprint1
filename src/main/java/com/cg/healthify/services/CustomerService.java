package com.cg.healthify.services;

import java.util.List;

import com.cg.healthify.pojo.Customer;

public interface CustomerService {
	
	public Customer addUser(Customer customer);

	public Customer updateUser(Customer customer);

	public Customer deleteUser(Customer customer);

	public int findUser(int id);

	public List<Customer> findAll();
	
	public void loginAuthentication(int id,String password);

}
