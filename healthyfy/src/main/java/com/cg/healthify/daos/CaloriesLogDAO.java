package com.cg.healthify.daos;

import com.cg.healthify.pojo.CaloriesLog;

public interface CaloriesLogDAO {

	public void addUserCalories(CaloriesLog calories);
	public void updateUserCalories(CaloriesLog calories);
	public void deleteUserCalories(CaloriesLog calories);
	public void findUserCalories(CaloriesLog calories);	
}
