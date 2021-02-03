package com.cg.healthify.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getMedicalCondition() {
		return medicalCondition;
	}
	public void setMedicalCondition(String medicalCondition) {
		this.medicalCondition = medicalCondition;
	}
	public String getAllergicTo() {
		return allergicTo;
	}
	public void setAllergicTo(String allergicTo) {
		this.allergicTo = allergicTo;
	}
	private String name; 
	private String gender;
	private String dob;
	private String contact;
	private String medicalCondition;
	private String allergicTo;
	
	public Customer(String name,String gender,String dob,String contact,String medicalCondition,String allergicTo) {
		super();
		this.name=name;
		this.gender=gender;
		this.dob=dob;
		this.contact=contact;
		this.medicalCondition=medicalCondition;
		this.allergicTo=allergicTo;
	}
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}

	
}
