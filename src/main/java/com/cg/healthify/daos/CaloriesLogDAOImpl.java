package com.cg.healthify.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.cg.healthify.exceptions.NegativeIdEntryException;
import com.cg.healthify.pojo.CaloriesLog;

import com.cg.healthify.util.DBUtil;




public class CaloriesLogDAOImpl implements CaloriesLogDAO {

	@Override
	public CaloriesLog addUserCalories(CaloriesLog calories) {
		 EntityManager em=DBUtil.emf.createEntityManager();
		 em.getTransaction().begin();	
			em.persist(calories);
		    System.out.println("Calories Log Added");
			em.getTransaction().commit();
			em.close();
			return calories;
	}

	@Override
	public CaloriesLog updateUserCalories(CaloriesLog calories) {
		EntityManager em=DBUtil.emf.createEntityManager();
		em.getTransaction().begin();
		calories=em.find(CaloriesLog.class,calories.getId());
		calories=em.find(CaloriesLog.class,calories.getCalories());
		//weg.setCaloriesLog(20.0);	
		calories.getUpdated_At();
		calories.getCreated_At();
		calories.getUpdateTime();
		calories.getCreateTime();
		em.persist(calories);
		System.out.println("Calories Log Updated At: " + calories.getUpdateTime());
		em.getTransaction().commit();
		em.close();
		return calories;
	}


	@Override
	public CaloriesLog deleteUserCalories(CaloriesLog calories) {
		EntityManager em=DBUtil.emf.createEntityManager();
		em.getTransaction().begin();
		calories=em.find(CaloriesLog.class,calories.getId());
		em.remove(calories);
		System.out.println("Your Current user Calories Log is Removed");
		em.getTransaction().commit();
		em.close();
		return calories;
		
	}

	@Override
	 public List<CaloriesLog> findAll() {
		 EntityManager em=DBUtil.emf.createEntityManager();
		 Query query=em.createQuery("from CaloriesLog");
			@SuppressWarnings("unchecked")
			List<CaloriesLog> list=(List<CaloriesLog>)query.getResultList();
			for(CaloriesLog log:list) {
				System.out.print("User Id: "+log.getId());
				System.out.print("Add your Calories: "+log.getCalories());
				System.out.print("Created date: "+log.getCreated_At());
				System.out.print("Updated date: "+log.getUpdated_At());
				System.out.print("Created time: "+log.getCreateTime());
				System.out.print("Updated time: "+log.getUpdateTime());
				System.out.println("\n");
			}
			return list;
	}
	@Override
	public CaloriesLog findById(int id) throws NullPointerException,NegativeIdEntryException {
		EntityManager em=DBUtil.emf.createEntityManager();
		em.getTransaction().begin();
		if(id<0) {
			throw new NegativeIdEntryException();
		}
		else {
		CaloriesLog log=em.find(CaloriesLog.class, id);
		if(log!=null) {
			System.out.print(" Id: "+log.getId());
			System.out.print("---Calories: "+log.getCalories());
			System.out.print("---Created date: "+log.getCreated_At());
			System.out.print("---Updated date: "+log.getUpdated_At());
			System.out.print("---Created time: "+log.getCreateTime());
			System.out.print("---Updated time: "+log.getUpdateTime());
			em.getTransaction().commit();
			em.close();
			return log;
		}
		else {
			throw new NullPointerException();
		}
		
		}
		
		
		
	}

}
