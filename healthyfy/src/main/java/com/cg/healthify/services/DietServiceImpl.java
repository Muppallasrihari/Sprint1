package com.cg.healthify.services;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import com.cg.healthify.constants.DietPlanConstants;
import com.cg.healthify.daos.DietDAOImpl;
import com.cg.healthify.exceptions.NoRecordFoundException;
import com.cg.healthify.pojo.DietPlan;
import com.cg.healthify.pojo.Login;
import com.cg.healthify.util.DBUtil;
public class DietServiceImpl extends DBUtil implements DietService {
	DietPlan diet = new DietPlan();
	DietDAOImpl dietdao = new DietDAOImpl();
	Login log = new Login();
	Scanner sc = new Scanner(System.in);

	public DietPlan addDiet(DietPlan diet) {
		EntityManager em=DBUtil.emf.createEntityManager();
		int io = 0;

		Query query = em.createQuery("from LoginInfo");
		List<Login> loginm = query.getResultList();
		for (Login i : loginm) {
			if (i.getId() == diet.getId()) {
				io++;
				break;
			}
		}

		if (io == 1) {
			if (diet.getTypeOfFood().equalsIgnoreCase("NONVEG")) {
				diet.setProteinRatio(DietPlanConstants.non_veg_protien_ratio);
				diet.setRatioOfFat(DietPlanConstants.nonVegFatRatio);
				diet.setRatioOfcarbs(DietPlanConstants.nonVegCarbsRatio);
			} else {
				diet.setProteinRatio(DietPlanConstants.veg_protien_ratio);
				diet.setRatioOfFat(DietPlanConstants.vegFatRatio);
				diet.setRatioOfcarbs(DietPlanConstants.vegFatRatio);
			}
			diet.setTotal(diet.getRatioOfcarbs() + diet.getRatioOfFat());
			dietdao.save_diet_plan(diet);
		} else {
			System.out.println("User record already exists");
		}

		return diet;
	}

	public DietPlan updateDiet(DietPlan diet) {
		EntityManager em=DBUtil.emf.createEntityManager();
		int io = 0;
		Query query = em.createQuery("from LoginInfo");
		List<Login> loginm = query.getResultList();
		for (Login i : loginm) {
			if (i.getId() == diet.getId()) {
				io++;
				break;
			}
		}

		if (io == 1) {
			DietPlan userExistingDietInfo = findDietData(diet.getId());
			if (userExistingDietInfo != null) {
				userExistingDietInfo.setSlots(diet.getSlots());
				dietdao.update_diet_plan(userExistingDietInfo);
			}
		} else {
			System.out.println("No Record Found");
		}

		return diet;
	}

	public DietPlan deleteDiet(DietPlan diet) {
		EntityManager em=DBUtil.emf.createEntityManager();
		int io = 0;
		Query query = em.createQuery("from LoginInfo");
		List<Login> loginm = query.getResultList();
		for (Login i : loginm) {
			if (i.getId() == diet.getId()) {
				io++;
				break;
			}
		}
		if (io == 1) {
			dietdao.remove_diet_plan(diet);
		} else {
			System.out.println("No Record Found");
		}
		return diet;
	}

	public DietPlan findDietData(int id) {
		EntityManager em=DBUtil.emf.createEntityManager();
		int io = 0;
		DietPlan dietPlanInfo = new DietPlan();

		Query query = em.createQuery("from LoginInfo");
		List<Login> loginm = query.getResultList();
		for (Login i : loginm) {
			if (i.getId() == id) {
				io++;
				break;
			}
		}

		if (io == 1) {
			dietPlanInfo = dietdao.customer_diet_plan_data(id);
		}

		return dietPlanInfo;
	}

	static void Validate(int io) throws NoRecordFoundException {
		if (io == 0) {
			throw new NoRecordFoundException("No Records Found");
		}
	}
}
