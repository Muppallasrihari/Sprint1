package com.cg.healthify.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Nutrition {
	@Id
	private int id;
	private String  name;
	private String plandescription;
	private String created_at;
	private int price;
	
	
	public Nutrition(int id, String name, String plandescription, String created_at, int price) {
		super();
		this.id = id;
		this.name = name;
		this.plandescription = plandescription;
		this.created_at = created_at;
		this.price = price;
	}
	
	public Nutrition() {
		super();
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
	public String getPlandescription() {
		return plandescription;
	}
	public void setPlandescription(String plandescription) {
		this.plandescription = plandescription;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	

	
	
	

}
