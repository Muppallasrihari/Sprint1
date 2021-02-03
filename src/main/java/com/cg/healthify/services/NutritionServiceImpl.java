package com.cg.healthify.services;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import com.cg.healthify.pojo.Login;
import com.cg.healthify.pojo.Nutrition;
import com.cg.healthify.util.DBUtil;
import com.cg.healthify.daos.NutritionDAOImpl;
import com.cg.healthify.exceptions.NoRecordFoundException;
import com.cg.healthify.exceptions.PaymentAmountException;

public class NutritionServiceImpl extends DBUtil implements NutritionService {

	Nutrition nutrition = new Nutrition();
	NutritionDAOImpl nutimpl = new NutritionDAOImpl();
	Login login = new Login();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addNutrition() {
		int io = 0;
		try {
			/*System.out.println("Enter your ID: ");
			nutrition.setId(sc.nextInt());*/
			Query query = em.createQuery("from Login");
			List<Login> loginm = query.getResultList();
			for (Login i : loginm) {
				if (i.getId() == nutrition.getId()) {
					io++;
					break;
				}
			}
		}

		catch (NoRecordFoundException m) {
			System.out.println(m);
		}
		if (io == 1) {

			System.out.println("Enter the Name: ");
			nutrition.setName(sc.next());
			System.out.println("Enter the plan description: ");
			nutrition.setPlandescription(sc.next());
			System.out.println("Enter the Price:");
			nutrition.setPrice(sc.nextInt());
			
			nutimpl.saveNutritionPlan(nutrition, login);
		}
	}

	static void Validate(double io) throws PaymentAmountException {
		if (io < 0) {
			throw new PaymentAmountException("Payment Should be postive or greater than zero ");
		}
	}

	@Override
	public void updateNutrition() {

		int io = 0;
		try {
			System.out.println("Please Confirm your ID to update nutrition plan ");
			nutrition.setId(sc.nextInt());
			Query query = em.createQuery("from Login");
			List<Login> loginm = query.getResultList();
			for (Login i : loginm) {
				if (i.getId() == nutrition.getId()) {
					io++;
					break;
				}
			}
		} catch (NoRecordFoundException m) {
			System.out.println(m);
		}
		if (io == 1) {
			System.out.println("Enter plan description");
			nutrition.setPlandescription(sc.next());
			System.out.println("Enter the Price:");
			nutrition.setPrice(sc.nextInt());
			nutimpl.updateNutritionPlan(nutrition);
		}
	}

	@Override
	public void deleteNutrition() {
		// TODO Auto-generated method stub
		int io = 0;
		try {
			System.out.println("Please Confirm your Id to remove your nutrition plan: ");
			nutrition.setId(sc.nextInt());
			Query query = em.createQuery("from Login");
			List<Login> loginm = query.getResultList();
			for (Login i : loginm) {
				if (i.getId() == nutrition.getId()) {
					io++;
					break;
				}
			}
		} catch (NoRecordFoundException m) {
			System.out.println(m);
		}
		if (io == 1) {
			nutimpl.removeNutritionPlan(nutrition);
		}
	}

	@Override
	public void findNutritionData() {
		// TODO Auto-generated method stub
		int io = 0;
		try {
			System.out.println("Please give your ID to get your nutrition details: ");
			nutrition.setId(sc.nextInt());
			Query query = em.createQuery("from Login");
			List<Login> loginm = query.getResultList();
			for (Login i : loginm) {
				if (i.getId() == nutrition.getId()) {
					io++;
					break;
				}
			}
		} catch (NoRecordFoundException m) {
			System.out.println(m);
		}
		if (io == 1) {
			nutimpl.CustomerNutritionPlan(nutrition);
		}

	}

}
