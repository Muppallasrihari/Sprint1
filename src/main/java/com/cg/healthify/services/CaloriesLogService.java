package com.cg.healthify.services;

import java.util.List;

import com.cg.healthify.exceptions.NegativeIdEntryException;
import com.cg.healthify.pojo.CaloriesLog;


public interface CaloriesLogService {

	public CaloriesLog addCaloriesLog(CaloriesLog calories);

	public CaloriesLog UpdateCaloriesLog(CaloriesLog calories) throws NullPointerException, NegativeIdEntryException;

	public CaloriesLog DeleteCaloriesLog(CaloriesLog calories);

	public List<CaloriesLog> findAll();
	
	public CaloriesLog findById(int id) throws NullPointerException, NegativeIdEntryException;

	public void validateId(int id) throws NegativeIdEntryException;
}
