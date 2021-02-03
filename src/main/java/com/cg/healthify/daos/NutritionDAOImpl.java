package com.cg.healthify.daos;

import com.cg.healthify.pojo.Login;
import com.cg.healthify.pojo.Nutrition;
import com.cg.healthify.util.DBUtil;

public class NutritionDAOImpl extends DBUtil implements NutritionDAO {

	@Override
	public void saveNutritionPlan(Nutrition nutrition, Login login) {
		nutrition = new Nutrition(nutrition.getId(), nutrition.getName(), nutrition.getPlandescription(),
				nutrition.getCreated_at(), nutrition.getPrice());
		em.getTransaction().begin();
		em.persist(nutrition);
		System.out.println("Nutrition Plan Saved.");
		em.getTransaction().commit();
	}

	@Override
	public void updateNutritionPlan(Nutrition nutrition) {

		em.getTransaction().begin();
		String newPlan = nutrition.getPlandescription();
		int newPrice = nutrition.getPrice();
		nutrition = em.find(Nutrition.class, nutrition.getId());
		nutrition.setPlandescription(newPlan);
		nutrition.setPrice(newPrice);
		em.persist(nutrition);
		System.out.println("Your nutrition plan is Updated...");
		em.getTransaction().commit();

	}

	@Override
	public void CustomerNutritionPlan(Nutrition nutrition) {
		em.getTransaction().begin();
		nutrition = em.find(Nutrition.class, nutrition.getId());
		System.out.println("NutritionID: " + nutrition.getId() + "\n" + "Name : " + nutrition.getName() + "\n"
				+ "Plan Description :" + nutrition.getPlandescription() + "\n" + "Price : " + nutrition.getPrice());
		em.getTransaction().commit();
	}

	@Override
	public void removeNutritionPlan(Nutrition nutrition) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();

		nutrition = em.find(Nutrition.class, nutrition.getId());
		em.remove(nutrition);
		System.out.println("Your Current nutrition Plan is Removed");

		em.getTransaction().commit();
	}

}
