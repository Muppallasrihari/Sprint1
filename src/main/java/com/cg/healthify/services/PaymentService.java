package com.cg.healthify.services;

import com.cg.healthify.pojo.Payment;

public interface PaymentService {

    public Payment addPayment( Payment payment);
    
    public Payment deletePayment(Payment payment);
    
    public int FindPayment(int id);
    
    public Payment updatePayment(Payment payment);
    
	
}
