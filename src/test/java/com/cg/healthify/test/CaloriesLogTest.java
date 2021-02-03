package com.cg.healthify.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.healthify.daos.CaloriesLogDAO;
import com.cg.healthify.daos.CaloriesLogDAOImpl;
import com.cg.healthify.exceptions.NegativeIdEntryException;
import com.cg.healthify.pojo.CaloriesLog;
import com.cg.healthify.services.CaloriesLogService;
import com.cg.healthify.services.CaloriesLogServiceImpl;

public class CaloriesLogTest {

	private static CaloriesLogService service;
	private static CaloriesLogDAO dao;
	private CaloriesLog caloriesMock1,caloriesMock2,caloriesMock3;

	@BeforeClass
	public static void setUpTestEnv() {
		dao = new CaloriesLogDAOImpl();
		service = new CaloriesLogServiceImpl();
		
	}

	@Before
	public void setUpTestMockData() {
		caloriesMock1 = new CaloriesLog(11,120, LocalDate.now(),LocalDate.now(),LocalTime.now(),LocalTime.now());
		caloriesMock2 = new CaloriesLog(-18,120, LocalDate.now(),LocalDate.now(),LocalTime.now(),LocalTime.now());	
		caloriesMock1 = dao.addUserCalories(caloriesMock1);
		caloriesMock1 = dao.addUserCalories(caloriesMock2);
	

	}

	@Test(expected = NullPointerException.class)
	public void testGetCaloriesLogDetailsForInvalidId() throws NullPointerException, NegativeIdEntryException {
		service.findById(9458);
	}
	
	@Test(expected = NegativeIdEntryException.class)
	public void testGetCaloriesLogtDetailsForNegativeId() throws NegativeIdEntryException{
		service.findById(-241);
	}
	
	@Test
	public void testGetCaloriesLogDetailsForValidId()  throws NullPointerException, NegativeIdEntryException {
		CaloriesLog log=service.findById(caloriesMock1.getId());
		assertEquals(log,caloriesMock1);
	}

	@Test(expected = NegativeIdEntryException.class)
	public void testUpdateCaloriesLogDetailsForNegativeId() throws NegativeIdEntryException{
		service.UpdateCaloriesLog(caloriesMock2);
	}
	@Test(expected = NullPointerException.class)
	public void testUpdateCaloriesLogDetailsForInvalidId() throws NullPointerException, NegativeIdEntryException{
		service.UpdateCaloriesLog(caloriesMock3);
	}

	@After
	public void tearDownTestMockData() {
		dao.deleteUserCalories(caloriesMock1);
		dao.deleteUserCalories(caloriesMock2);

	}

	@AfterClass
	public static void tearDownTestEnv() {
		service = null;
		dao = null;
	}
	
}

