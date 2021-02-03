package com.cg.healthify.daos;

import com.cg.healthify.pojo.DietPlan;
import com.cg.healthify.pojo.Login;

public interface DietDAO {
	
	 void saveDiet(DietPlan diet,Login login);

	 void updateDietPlan(DietPlan diet);
   
	 void removeDietPlan(DietPlan diet);

	 void customerDietPlan(DietPlan diet);

}
