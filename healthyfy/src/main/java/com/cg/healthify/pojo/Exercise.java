package com.cg.healthify.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Exercise {
	@Id
	private int Id;
	private String exerciseType;
	private String exercisePlan;
	
	public Exercise(int id, String exerciseType, String exercisePlan) {
		super();
		Id = id;
		this.exerciseType = exerciseType;
		this.exercisePlan = exercisePlan;
	}
	
	public Exercise() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getExerciseType() {
		return exerciseType;
	}
	public void setExerciseType(String exerciseType) {
		this.exerciseType = exerciseType;
	}
	public String getExercisePlan() {
		return exercisePlan;
	}
	public void setExercisePlan(String exercisePlan) {
		this.exercisePlan = exercisePlan;
	}
	
	
	
}
