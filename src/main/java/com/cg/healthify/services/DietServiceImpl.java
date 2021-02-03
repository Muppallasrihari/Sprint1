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

public class DietServiceImpl extends DBUtil {
	DietPlan diet = new DietPlan();
	DietDAOImpl dietdao = new DietDAOImpl();
	Login log = new Login();
	Scanner sc = new Scanner(System.in);

	public DietPlan addDiet(DietPlan diet) {
		int io = 0;
		try {
			
			Query query = em.createQuery("from Login");
			List<Login> loginm = query.getResultList();
			for (Login i : loginm) {
				if (i.getId() == diet.getId()) {
					io++;
					break;
				}
			}
			Validate(io);
		} catch (NoRecordFoundException m) {
			System.out.println(m);
		}
		if (io == 1) {
			if (diet.getTypeOfFood().equalsIgnoreCase("NONVEG")) {
				diet.setProteinRatio(DietPlanConstants.non_veg_protien_ratio);
			} else {
				diet.setProteinRatio(DietPlanConstants.veg_protien_ratio);
			}
			dietdao.savePlan(diet, log);
		}
		return diet;
	}

	static void Validate(int io) throws NoRecordFoundException {
		if (io == 0) {
			throw new NoRecordFoundException("No Records Found");
		}
	}

	public DietPlan updateDiet(DietPlan diet) {
		int io = 0;
		try {
			
			Query query = em.createQuery("from Login");
			List<Login> loginm = query.getResultList();
			for (Login i : loginm) {
				if (i.getId() == diet.getId()) {
					io++;
					break;
				}
			}
			Validate(io);
		} catch (NoRecordFoundException m) {
			System.out.println(m);
		}
		if (io == 1) {
			dietdao.updatePlan(diet);
		}
		return diet;
	}

	public DietPlan deleteDiet(DietPlan diet) {
		int io = 0;
		try {
			
			Query query = em.createQuery("from Login");
			List<Login> loginm = query.getResultList();
			for (Login i : loginm) {
				if (i.getId() == diet.getId()) {
					io++;
					break;
				}
			}
			Validate(io);
		} catch (NoRecordFoundException m) {
			System.out.println(m);
		}
		if (io == 1) {
			dietdao.removePlan(diet);
		}
		return diet;
	}

	public DietPlan findDietData(DietPlan diet) {
		int io = 0;
		try {
			
			Query query = em.createQuery("from Login");
			List<Login> loginm = query.getResultList();
			for (Login i : loginm) {
				if (i.getId() == diet.getId()) {
					io++;
					break;
				}
			}
			Validate(io);
		} catch (NoRecordFoundException m) {
			System.out.println(m);
		}
		if (io == 1) {
			dietdao.customerDietPlan(diet);
		}
		return diet;
	}

}
