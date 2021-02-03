package com.cg.healthify.services;

import java.util.Scanner;

import com.cg.healthify.daos.WeightLogDAOImpl;
import com.cg.healthify.pojo.WeightLog;
import com.cg.healthify.util.DBUtil;

public class WeightLogServiceImpl extends DBUtil implements WeightLogService{


	WeightLog weight=new WeightLog();
	WeightLogDAOImpl wdao=new WeightLogDAOImpl();
	Scanner sc=new Scanner(System.in);
	@Override
	public void addWeightLog() {
		// TODO Auto-generated method stub
		wdao.addUserWeight(weight);
		
	}

	@Override
	public void UpdateWeightLog() {
		// TODO Auto-generated method stub
		wdao.updateUserWeight(weight);

	}

	@Override
	public void DeleteWeightLog() {
		// TODO Auto-generated method stub
		wdao.deleteUserWeight(weight);

	}

	@Override
	public void findWeightLog() {
		// TODO Auto-generated method stub
		wdao.findUserWeight(weight);

	}

}
