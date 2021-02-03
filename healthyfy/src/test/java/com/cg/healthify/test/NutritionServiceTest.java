package com.cg.healthify.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.healthify.daos.NutritionDAO;
import com.cg.healthify.daos.NutritionDAOImpl;
import com.cg.healthify.exceptions.NegativeIdException;
import com.cg.healthify.pojo.Nutrition;
import com.cg.healthify.services.NutritionService;
import com.cg.healthify.services.NutritionServiceImpl;



public class NutritionServiceTest {

	private static NutritionService nutriPlanService;
	private static NutritionDAO nutriPlanDao;
	private Nutrition nutritionMock1,nutritionMock2,nutritionMock3;

	@BeforeClass
	public static void setUpTestEnv() {
		nutriPlanDao = new NutritionDAOImpl();
		nutriPlanService = new NutritionServiceImpl();
		
	}

	@Before
	public void setUpTestMockData() {
		nutritionMock1 = new Nutrition(111, "Morning Diet", "High Protien Food is Provided", LocalDate.now(),
				LocalDate.now(), 10000);
		nutritionMock2 = new Nutrition(-112, "Afternoon Diet", "High Protien Food is Provided", LocalDate.now(),
				LocalDate.now(), 10000);
		nutritionMock3 = new Nutrition(112, "Afternoon Diet", "High Protien Food is Provided", LocalDate.now(),
				LocalDate.now(), 10000);
		nutritionMock1 = nutriPlanDao.save(nutritionMock1);
		nutritionMock2 = nutriPlanDao.save(nutritionMock2);

	}

	@Test(expected = NullPointerException.class)
	public void testGetNutritionPlanDetailsForInvalidId() throws NullPointerException, NegativeIdException {
		nutriPlanService.findById(293793);
	}
	
	@Test(expected = NegativeIdException.class)
	public void testGetNutritionPlantDetailsForNegativeId() throws NegativeIdException{
		nutriPlanService.findById(-101);
	}
	
	@Test
	public void testGetNutritionPlanDetailsForValidId()  throws NullPointerException, NegativeIdException {
		Nutrition nutriPlan=nutriPlanService.findById(nutritionMock1.getId());
		assertEquals(nutriPlan,nutritionMock1);
	}

	@Test(expected = NegativeIdException.class)
	public void testUpdateNutritionPlanDetailsForNegativeId() throws NegativeIdException{
		nutriPlanService.update(nutritionMock2);
	}
	@Test(expected = NullPointerException.class)
	public void testUpdateNutritionPlanDetailsForInvalidId() throws NullPointerException, NegativeIdException{
		nutriPlanService.update(nutritionMock3);
	}

	@After
	public void tearDownTestMockData() {
		nutriPlanDao.delete(nutritionMock1);
		nutriPlanDao.delete(nutritionMock2);

	}

	@AfterClass
	public static void tearDownTestEnv() {
		nutriPlanService = null;
		nutriPlanDao = null;
	}

}
