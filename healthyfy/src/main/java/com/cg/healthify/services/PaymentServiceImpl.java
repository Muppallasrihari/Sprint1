package com.cg.healthify.services;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import com.cg.healthify.constants.PaymentConstants;
import com.cg.healthify.daos.PaymentDAOImpl;
import com.cg.healthify.exceptions.NoRecordFoundException;
import com.cg.healthify.exceptions.PaymentAmountException;
import com.cg.healthify.pojo.Login;
import com.cg.healthify.pojo.Payment;
import com.cg.healthify.util.DBUtil;

public class PaymentServiceImpl extends DBUtil implements PaymentService {
	Payment payment = new Payment();
	PaymentDAOImpl pdao = new PaymentDAOImpl();
	Scanner sc = new Scanner(System.in);

	@Override
	public Payment addPayment(Payment payment) {
		// TODO Auto-generated method stub
		/*
		 * try { System.out.println("Enter your PAYID: "); payment.setId(sc.nextInt());
		 * login.setId(payment.getId());
		 * System.out.println("Enter your payment Gateway: ");
		 * payment.setPlanCategory(sc.next()); System.out.println("Enter your Payment");
		 * payment.setPayment(sc.nextDouble()); Validate(payment.getPayment()); } catch
		 * (Exception e) { System.out.println(e); System.exit(0); }
		 */
		try {
			Validate(payment.getPayment());
		} catch (PaymentAmountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}

		if (payment.getPlanCategory().equalsIgnoreCase("UPI")) {
			payment.setDiscount(PaymentConstants.gold);
		} else if (payment.getPlanCategory().equalsIgnoreCase("CARD")) {
			payment.setDiscount(PaymentConstants.platinum);
		} else {
			payment.setDiscount(PaymentConstants.silver);
		}
		double netPay = payment.getPayment() - ((payment.getPayment() * payment.getDiscount()) / 100);
		payment.setPayableAmount(netPay);

		return pdao.save(payment);
	}

	@Override
	public Payment deletePayment(Payment payment) {
		// TODO Auto-generated method stub
		/*
		 * System.out.
		 * println("Please confirm your PAYID to delete your payment details.");
		 * payment.setId(sc.nextInt()); System.out.println(payment.getPlanCategory());
		 * String n = payment.getPlanCategory();
		 */
		if (payment.getPlanCategory() == null) {
			System.out.println("NO RECORD IN PAYMENT PORTAL");
		} else {
			payment = pdao.delete(payment);
		}

		return payment;

	}

	@Override
	public int FindPayment(int id) throws NoRecordFoundException {
		// TODO Auto-generated method stub
		/*
		 * System.out.println("Enter your PAYID to fetch your Details: ");
		 * payment.setId(sc.nextInt());
		 */
		int io = 0;
		try {
			Query query = em.createQuery("from Login");
			List<Login> loginm = query.getResultList();
			for (Login i : loginm) {
				if (i.getId() == id) {
					io++;
					break;
				}
			}
			Validat(io);
		} catch (NoRecordFoundException m) {
			System.out.println(m);
		}
		if(io==1)
		{
		pdao.FindUser(id);
		}
		else {
			
		}
		
		return id;
	}

	@Override
	public Payment updatePayment(Payment payment) {
		// TODO Auto-generated method stub
		/*
		 * System.out.println("Enter the PAYID to Update payment details: ");
		 * payment.setId(sc.nextInt());
		 * System.out.println("Enter your new payment gateway");
		 * payment.setPlanCategory(sc.next());
		 * System.out.println("Enter your new payment");
		 * payment.setPayment(sc.nextDouble());
		 */
		if (payment.getPlanCategory().equalsIgnoreCase("UPI")) {
			payment.setDiscount(PaymentConstants.gold);
		} else if (payment.getPlanCategory().equalsIgnoreCase("CARD")) {
			payment.setDiscount(PaymentConstants.platinum);
		} else {
			payment.setDiscount(PaymentConstants.silver);
		}
		double netPay = payment.getPayment() - ((payment.getPayment() * payment.getDiscount()) / 100);
		payment.setPayableAmount(netPay);
		return pdao.update(payment);

	}

	static void Validate(double d) throws PaymentAmountException {
		if (d < 0) {
			throw new PaymentAmountException("Payment Should be postive or greater than zero ");
		}
	
	}
	static void Validat(int i) throws NoRecordFoundException {
		if (i == 0) {
			throw new NoRecordFoundException("No record ");
		}
	}
	}
