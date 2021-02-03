package com.cg.healthify.daos;

import com.cg.healthify.pojo.DietPlan;
import com.cg.healthify.pojo.Login;

public interface DietDAO {
	public DietPlan save_diet_plan(DietPlan diet);

	public DietPlan update_diet_plan(DietPlan diet);

	public DietPlan remove_diet_plan(DietPlan diet);

	public DietPlan customer_diet_plan_data(int id);
}
