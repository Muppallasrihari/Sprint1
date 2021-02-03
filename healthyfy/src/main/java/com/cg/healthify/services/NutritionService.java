package com.cg.healthify.services;

import java.util.List;

import com.cg.healthify.exceptions.NegativeIdException;
import com.cg.healthify.pojo.Nutrition;

public interface NutritionService {

	public Nutrition save(Nutrition nutritionPlan);

	public List<Nutrition> findAll();
	
	public Nutrition update(Nutrition nutritionPlan) throws NegativeIdException,NullPointerException ;

	public Nutrition delete(Nutrition nutritionPlan);

	public Nutrition findById(int id) throws NullPointerException, NegativeIdException;

	public void validateId(int id) throws NegativeIdException;

}
