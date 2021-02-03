package com.cg.healthify.services;

import java.util.List;

import javax.persistence.EntityManager;

import com.cg.healthify.pojo.Nutrition;
import com.cg.healthify.util.DBUtil;
import com.cg.healthify.daos.NutritionDAO;
import com.cg.healthify.daos.NutritionDAOImpl;
import com.cg.healthify.exceptions.NegativeIdException;


public class NutritionServiceImpl extends DBUtil implements NutritionService {
	public NutritionDAO nutriPlanDAO;

	public NutritionServiceImpl() {
		nutriPlanDAO = new NutritionDAOImpl();
	}
	@Override
	public Nutrition save(Nutrition nutritionPlan) {
		nutriPlanDAO.save(nutritionPlan);
		return nutritionPlan;
	}
	
	@Override
	public List<Nutrition> findAll() {
		nutriPlanDAO.findAll();
		return null;
	}

	@Override
	public Nutrition update(Nutrition nutritionPlan) throws NegativeIdException ,NullPointerException{
		EntityManager em=DBUtil.emf.createEntityManager();
		em.getTransaction().begin();
		Nutrition plan=em.find(Nutrition.class, nutritionPlan.getId());
		if(nutritionPlan.getId()<0) {
			throw new NegativeIdException();
		}
		else if(plan!=null) {
			nutriPlanDAO.update(nutritionPlan);
			return nutritionPlan;
		}
		else {
			throw new NullPointerException();
		}
			
		
	}

	@Override
	public Nutrition delete(Nutrition nutritionPlan) {
		nutriPlanDAO.delete(nutritionPlan);
		return nutritionPlan;
	}

	@Override
	public Nutrition findById(int id) throws NullPointerException, NegativeIdException {
		if(id<0) {
			throw new NegativeIdException();
		}
		else {
			Nutrition plan=nutriPlanDAO.findById(id);
			return plan;
		}
		
	}

	@Override
	public void validateId(int id) throws NegativeIdException {
		if(id<0) {
			throw new NegativeIdException("Id should not be null.");
		}

	}

	

}
