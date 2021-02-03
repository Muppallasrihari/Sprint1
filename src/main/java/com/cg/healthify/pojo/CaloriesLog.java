package com.cg.healthify.pojo;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * In this class all the data in the module is stored and same is manipulated in all the classes of the app.
 * This model class is foundation of CaloriesLog Module.
 * @author shweta
 *
 */


@Entity
public class CaloriesLog {
	
	@Id
	private int id;
	/*
	 * Store Calories.
	 * Cannot be negative .
	 * Does work with decimal values.
	 */
	private double calories;
	/*
	 * stores date of the creation of record.
	 * Does automatically from your device.
	 */
	private LocalDate created_At;
	/*
	 * stores date of the updation of record.
	 * Does automatically from your device.
	 */
	private LocalDate Updated_At;
	/*
	 * stores time of the creation of record.
	 * Does automatically from your device.
	 */
	private LocalTime createTime;
	/*
	 * stores time of the creation of record.
	 * Does automatically from your device.
	 */
	private LocalTime updateTime;
	
	/**
	 * provides default values to the things user do not provide.
	 */
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
	
	/**
	 * Below are getters and setters methods for getting and storing data.
	 * @return
	 */
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

	/**
	 * To String method to return all kind of  data in string format.
	 */
	@Override
	public String toString() {
		return "CaloriesLog [id=" + id + ", calories=" + calories + ", created_At=" + created_At + ", Updated_At="
				+ Updated_At + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

	
}
