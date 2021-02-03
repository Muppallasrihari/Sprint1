package com.cg.healthify.daos;

import java.time.LocalDate;
import java.time.LocalTime;

import com.cg.healthify.pojo.CaloriesLog;
import com.cg.healthify.pojo.WeightLog;
import com.cg.healthify.util.DBUtil;

public class CaloriesLogDAOImpl extends DBUtil implements CaloriesLogDAO {

	@Override
	public void addUserCalories(CaloriesLog calories) {
		calories = new CaloriesLog(calories.getId(), calories.getCalories(), calories.getCreated_At(), calories.getUpdated_At(),
				calories.getCreateTime(), calories.getUpdateTime());
		em.getTransaction().begin();
		em.persist(calories);
		System.out.println("Calories Log Added");
		em.getTransaction().commit();
	}

	@Override
	public void updateUserCalories(CaloriesLog calories) {
		// TODO Auto-generated method stub
		LocalDate newDate = calories.getUpdated_At();
		LocalTime newTime = calories.getUpdateTime();
		double newCalories = calories.getCalories();
		em.getTransaction().begin();
		calories = em.find(CaloriesLog.class, calories.getId());
		calories.setCalories(newCalories);
		calories.setUpdated_At(newDate);
		calories.setUpdateTime(newTime);
		System.out.println("Calories Log Updated At: " + calories.getUpdateTime());
		em.getTransaction().commit();
	}


	@Override
	public void deleteUserCalories(CaloriesLog calories) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		calories = em.find(CaloriesLog.class, calories.getId());
		em.remove(calories);
		System.out.println("Your Current user Weight is Removed");
		em.getTransaction().commit();
		
	}

	@Override
	public void findUserCalories(CaloriesLog calories) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		calories = em.find(CaloriesLog.class, calories.getId());
		System.out.println("ID:" + calories.getId() + "\n" + "Calories : "+calories.getCalories()+ "\n"+"Date : "+calories.getCreated_At());
		em.getTransaction().commit();
	}

	
	
}
