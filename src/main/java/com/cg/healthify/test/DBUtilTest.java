package com.cg.healthify.test;

import com.cg.healthify.daos.PaymentDAO;
import com.cg.healthify.daos.PaymentDAOImpl;
import com.cg.healthify.pojo.Payment;

public class DBUtilTest {
	public static void main(String args[])
	{
	
		PaymentDAO paymentdao = new PaymentDAOImpl();
		/*Payment payment = new Payment(2, 20000, 10, "29-01-2021", "25-02-2021", 102, 2);
		
		paymentdao.save(payment);
		System.out.println("Added succesfully!");
		
		paymentdao.delete(1);
		System.out.println("deleted successfully!");*/
		//paymentdao.update(2, 120, "10-02-2021");
		//System.out.println("Updated succesfully!");

		
		
	}

}
