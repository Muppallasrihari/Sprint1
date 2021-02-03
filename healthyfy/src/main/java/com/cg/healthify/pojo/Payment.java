package com.cg.healthify.pojo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment {
	@Id
	/*
	 * This represents id of payment 
	 */
	private int id;
	/*
	 * This represents amount of payment 
	 */
	private double payment;
	/*
	 * This represents discount amount of payment 
	 */
	private double discount;
		/*
	 * This represents date of payment 
	 */
	private String created_At;
	
	private String planCategory;
	
	private double payableAmount;

	
	public Payment(int id, double payment, double discount, String created_At, String planCategory,
			double payableAmount) {
		super();
		this.id = id;
		this.payment = payment;
		this.discount = discount;
		this.created_At = created_At;
		this.planCategory = planCategory;
		this.payableAmount = payableAmount;
	}

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getCreated_At() {
		return created_At;
	}

	public void setCreated_At(String created_At) {
		this.created_At = created_At;
	}

	public String getPlanCategory() {
		return planCategory;
	}

	public void setPlanCategory(String planCategory) {
		this.planCategory = planCategory;
	}

	public double getPayableAmount() {
		return payableAmount;
	}

	public void setPayableAmount(double payableAmount) {
		this.payableAmount = payableAmount;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", payment=" + payment + ", discount=" + discount + ", created_At=" + created_At
				+ ", planCategory=" + planCategory + ", payableAmount=" + payableAmount + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created_At == null) ? 0 : created_At.hashCode());
		long temp;
		temp = Double.doubleToLongBits(discount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		temp = Double.doubleToLongBits(payableAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(payment);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((planCategory == null) ? 0 : planCategory.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		if (created_At == null) {
			if (other.created_At != null)
				return false;
		} else if (!created_At.equals(other.created_At))
			return false;
		if (Double.doubleToLongBits(discount) != Double.doubleToLongBits(other.discount))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(payableAmount) != Double.doubleToLongBits(other.payableAmount))
			return false;
		if (Double.doubleToLongBits(payment) != Double.doubleToLongBits(other.payment))
			return false;
		if (planCategory == null) {
			if (other.planCategory != null)
				return false;
		} else if (!planCategory.equals(other.planCategory))
			return false;
		return true;
	}


	
	
}
