package com.cg.healthify.daos;

import com.cg.healthify.pojo.DietPlan;
import com.cg.healthify.pojo.Login;
import com.cg.healthify.util.DBUtil;

public class DietDAOImpl extends DBUtil {

	public void savePlan(DietPlan diet, Login login) {
		diet = new DietPlan(diet.getId(), diet.getSlots(), diet.getTypeOfFood(), diet.getProteinRatio());
		em.getTransaction().begin();
		em.persist(diet);
		System.out.println("Diet Plan Saved.");
		em.getTransaction().commit();
	}

	public void updatePlan(DietPlan diet) {
		String new_slot = diet.getSlots();
		em.getTransaction().begin();
		diet = em.find(DietPlan.class, diet.getId());
		diet.setSlots(new_slot);
		em.persist(diet);
		System.out.println("Your diet plan is Updated...");
		em.getTransaction().commit();
	}

	public void removePlan(DietPlan diet) {
		diet = em.find(DietPlan.class, diet.getId());
		em.getTransaction().begin();
		em.remove(diet);
		System.out.println("Your Current Diet Plan is Removed");
		em.getTransaction().commit();
	}

	public void customerDietPlan(DietPlan diet) {
		em.getTransaction().begin();
		diet = em.find(DietPlan.class, diet.getId());
		System.out.println("DietID: " + diet.getId() + "\n" + "Slots: " + diet.getSlots() + "\n" + "FOOD TYPE"
				+ diet.getTypeOfFood() + "\n" + "PROTIEN RATIO" + diet.getProteinRatio());
		em.getTransaction().commit();
	}
}
