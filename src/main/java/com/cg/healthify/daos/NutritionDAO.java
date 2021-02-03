package com.cg.healthify.daos;

import com.cg.healthify.pojo.Login;
import com.cg.healthify.pojo.Nutrition;

public interface NutritionDAO {

	void saveNutritionPlan(Nutrition nutrition,Login login);

	 void updateNutritionPlan(Nutrition nutrition);
  
	 void removeNutritionPlan(Nutrition nutrition);

	 void CustomerNutritionPlan(Nutrition nutrition);
}
