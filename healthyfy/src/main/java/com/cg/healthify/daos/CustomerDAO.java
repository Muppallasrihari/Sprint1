package com.cg.healthify.daos;

import java.util.List;

import com.cg.healthify.exceptions.NoRecordFoundException;
import com.cg.healthify.pojo.Customer;

public interface CustomerDAO {

	public Customer saveCustomer(Customer cust);

	public Customer updateCustomer(Customer cust) throws NoRecordFoundException;

	public Customer cancelPlan(Customer cust)throws NoRecordFoundException;

	public Customer findByUser(int i)throws NoRecordFoundException;

	public List<Customer> findAll();
}
