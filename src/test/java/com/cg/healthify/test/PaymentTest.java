package com.cg.healthify.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.healthify.daos.PaymentDAO;
import com.cg.healthify.daos.PaymentDAOImpl;
import com.cg.healthify.pojo.Payment;
import com.cg.healthify.services.PaymentService;
import com.cg.healthify.services.PaymentServiceImpl;

public class PaymentTest {

	private static PaymentService service;
	private static PaymentDAO dao;
	private Payment payment;

	@BeforeClass
	public static void setup() {
		dao = new PaymentDAOImpl();
		service = new PaymentServiceImpl();

	}

	@Before
	public void setUpMockData() {
		Payment payment = new Payment( 10000, , 0, "02.01.21", "UPI", 9200);
		payment = dao.save(payment);
		
	}
	
	@Test
	public void showPaymentDetailsInvalid(){
		service.FindPayment(24);
	}

	@Test
	public void testGetProductDetails() {
		int payment1 = service.FindPayment(payment.getId());
		assertEquals(payment1,payment);
		
	}

	@Test
	public void showPaymentDetailsvalid(){
		service.FindPayment(1);
	}
	
	@After 
	public void tearDownTestMockData() {
		
		dao.delete(payment);
		
	}
	@AfterClass
	public static  void tearDownTestEnv() {
		service = null;
		dao= null;
	}
}
