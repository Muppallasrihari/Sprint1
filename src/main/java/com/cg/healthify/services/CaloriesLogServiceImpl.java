package com.cg.healthify.services;

import java.util.List;

import javax.persistence.EntityManager;

import com.cg.healthify.daos.CaloriesLogDAO;
import com.cg.healthify.daos.CaloriesLogDAOImpl;
import com.cg.healthify.exceptions.NegativeIdEntryException;
import com.cg.healthify.pojo.CaloriesLog;

import com.cg.healthify.util.DBUtil;



public class CaloriesLogServiceImpl extends DBUtil implements CaloriesLogService {
public CaloriesLogDAO calorieslogDAO;
	
	public CaloriesLogServiceImpl() {
		calorieslogDAO=new CaloriesLogDAOImpl();
	}
	
	@Override
	public CaloriesLog addCaloriesLog(CaloriesLog calories) {
		return calorieslogDAO.addUserCalories(calories);
		
	}

	@Override
	public CaloriesLog UpdateCaloriesLog(CaloriesLog calories) throws NegativeIdEntryException, NullPointerException{
		EntityManager em=DBUtil.emf.createEntityManager();
		em.getTransaction().begin();
		CaloriesLog log=em.find(CaloriesLog.class, calories.getId());
		if(calories.getId()<0) {
			throw new NegativeIdEntryException();
		}
		else if(log!=null) {
			calorieslogDAO.updateUserCalories(calories);
			return calories;
		}
		else {
			throw new NullPointerException();
		}
		
	}

	@Override
	public CaloriesLog DeleteCaloriesLog(CaloriesLog calories) {
		return calorieslogDAO.deleteUserCalories(calories);
		
	}

	@Override
	public List<CaloriesLog> findAll() {
		return calorieslogDAO.findAll();
		
	}
	
	@Override
	public CaloriesLog findById(int id) throws NullPointerException, NegativeIdEntryException {
		if(id<0) {
			throw new NegativeIdEntryException();
		}
		else {
			CaloriesLog log=calorieslogDAO.findById(id);
			return log;
		}
		
	}

	@Override
	public void validateId(int id) throws NegativeIdEntryException {
		if(id<0) {
			throw new NegativeIdEntryException("Id should not be null.");
		}

	}

}
