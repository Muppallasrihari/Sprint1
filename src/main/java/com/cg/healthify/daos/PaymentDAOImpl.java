package com.cg.healthify.daos;

import com.cg.healthify.pojo.Payment;
import com.cg.healthify.util.DBUtil;

public class PaymentDAOImpl extends DBUtil implements PaymentDAO {

	@Override
	public Payment save(Payment payment) {

		payment = new Payment(payment.getId(), payment.getPayment(), payment.getDiscount(), payment.getCreated_At(),
				payment.getPlanCategory(), payment.getPayableAmount());
		em.getTransaction().begin();
	//	System.out.println("You have to pay " + payment.getPayableAmount() + " for your plan");
		em.persist(payment);
		em.getTransaction().commit();
		return payment;
	}

	@Override
	public Payment delete(Payment payment) {
		em.getTransaction().begin();
		payment = em.find(Payment.class, payment.getId());
		em.remove(payment);
		System.out.println("Payment Deleted");
		em.getTransaction().commit();
		return payment;
	}

	@Override
	public Payment FindAllPayments(Payment payment) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		payment = em.find(Payment.class, payment.getId());
		System.out.println("Your PAYID: " + payment.getId() + "\nDiscount: " + payment.getDiscount()+"\n"+"DATE :"+payment.getCreated_At());
		System.out.println(
				"Your PaymentAmount: " + payment.getPayment() + "\nYour Payment Gateway: " + payment.getPlanCategory());
		System.out.println("Your Net Pay Amount: " + payment.getPayableAmount());
		em.getTransaction().commit();
		return payment;
	}

	@Override
	public Payment update(Payment payment) {
		// TODO Auto-generated method stub
		String newGateway = payment.getPlanCategory();
		double newDiscount = payment.getDiscount();
		double newPayment = payment.getPayment();
		double newNetPayableAmount = payment.getPayableAmount();
		em.getTransaction().begin();
		payment = em.find(Payment.class, payment.getId());
		payment.setPlanCategory(newGateway);
		payment.setDiscount(newDiscount);
		payment.setPayment(newPayment);
		payment.setPayableAmount(newNetPayableAmount);
		em.persist(payment);
		System.out.println("Payment Details Updated");
		em.getTransaction().commit();
		return payment;
	}


	@Override
	public int FindUser(int id) {
		// TODO Auto-generated method stub
		Payment payment=new Payment();
		payment=em.find(Payment.class, id);
		em.getTransaction().begin();
		System.out.println("ID: "+payment.getId());
		System.out.println("Payment : "+payment.getPayment());
		System.out.println("Plan Category: "+payment.getPlanCategory());
		return 0;
	}
}