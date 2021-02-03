package com.cg.healthify.daos;

import java.time.LocalDate;
import java.time.LocalTime;

import com.cg.healthify.pojo.Exercise;
import com.cg.healthify.pojo.WeightLog;
import com.cg.healthify.util.DBUtil;

public class WeightLogDAOImpl extends DBUtil implements WeightLogDAO{

	@Override
	public WeightLog addUserWeight(WeightLog weight) {
		// TODO Auto-generated method stub
		weight=new WeightLog(weight.getId(),weight.getWeight(),weight.getCreated_At(),weight.getUpdated_At(),weight.getCreateTime(),weight.getUpdateTime());
	    em.getTransaction().begin();
	    em.persist(weight);
	    System.out.println("Weight Log Added");
	    em.getTransaction().commit();
		return weight;
	}

	@Override
	public WeightLog updateUserWeight(WeightLog weight) {
		LocalDate newDate=weight.getUpdated_At();
		LocalTime newTime=weight.getUpdateTime();
		double newWeight=weight.getWeight();
		em.getTransaction().begin();
		weight=em.find(WeightLog.class, weight.getId());
		weight.setWeight(newWeight);
		weight.setUpdated_At(newDate);
		weight.setUpdateTime(newTime);
		System.out.println("Weight Log Updated At: "+weight.getUpdateTime());
		em.getTransaction().commit();
		return weight;
		
	}

	@Override
	public WeightLog deleteUserWeight(WeightLog weight) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		weight = em.find(WeightLog.class, weight.getId());
		em.remove(weight);
		System.out.println("Your Current user Weight is Removed");
		em.getTransaction().commit();
		return weight;
		
	}

	@Override
	public WeightLog findUserWeight(WeightLog weight) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		weight = em.find(WeightLog.class, weight.getId());
		System.out.println("ID:" + weight.getId() + "\n" + "Weight : "+weight.getWeight()+ "\n"+"Date : "+weight.getCreated_At());
		em.getTransaction().commit();
		return weight;
	}
	

}
