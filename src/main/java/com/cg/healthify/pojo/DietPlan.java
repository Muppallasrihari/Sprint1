package com.cg.healthify.pojo;



import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DietPlan {

		@Id
		int id;
		private String slots;
		private String typeOfFood;
		private double proteinRatio;
		//private double ratioOfFat;
		//private double ratioOfcarbs;
		//private double total;
		public DietPlan(int id, String slots, String typeOfFood, double proteinRatio) {
			super();
			this.id = id;
			this.slots = slots;
			this.typeOfFood = typeOfFood;
			this.proteinRatio = proteinRatio;
		}
		
		public DietPlan() {
			super();
			// TODO Auto-generated constructor stub
		}

		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		public String getSlots() {
			return slots;
		}
		public void setSlots(String slots) {
			this.slots = slots;
		}
		public String getTypeOfFood() {
			return typeOfFood;
		}
		public void setTypeOfFood(String typeOfFood) {
			this.typeOfFood = typeOfFood;
		}
		public double getProteinRatio() {
			return proteinRatio;
		}
		public void setProteinRatio(double proteinRatio) {
			this.proteinRatio = proteinRatio;
		}
 
		
}
