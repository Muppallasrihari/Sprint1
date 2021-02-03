package com.cg.healthify.pojo;


import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CaloriesLog {

	@Id
	private int id;
	private double calories;
	private LocalDate created_At;
	private LocalDate Updated_At;
	private LocalTime createTime;
	private LocalTime updateTime;
	
	
	public CaloriesLog(int id, double calories, LocalDate created_At, LocalDate updated_At, LocalTime createTime,
			LocalTime updateTime) {
		super();
		this.id = id;
		this.calories = calories;
		this.created_At = created_At;
		Updated_At = updated_At;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public CaloriesLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public LocalDate getCreated_At() {
		return created_At;
	}
	public void setCreated_At(LocalDate created_At) {
		this.created_At = created_At;
	}
	public LocalDate getUpdated_At() {
		return Updated_At;
	}
	public void setUpdated_At(LocalDate updated_At) {
		Updated_At = updated_At;
	}
	public LocalTime getCreateTime() {
		return createTime;
	}
	public void setCreateTime(LocalTime createTime) {
		this.createTime = createTime;
	}
	public LocalTime getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(LocalTime updateTime) {
		this.updateTime = updateTime;
	}

}
