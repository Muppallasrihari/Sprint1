package com.cg.healthify.services;

import java.util.Scanner;

import com.cg.healthify.daos.WeightLogDAOImpl;
import com.cg.healthify.pojo.WeightLog;
import com.cg.healthify.util.DBUtil;

public class WeightLogServiceImpl extends DBUtil implements WeightLogService{

WeightLogDAOImpl wdao=new WeightLogDAOImpl();
	
	
	@Override
	public WeightLog addWeightLog(WeightLog weightLog) {

	wdao.addUserWeight(weightLog);
	return weightLog;
	
	}
        @Override
	public WeightLog updateWeightLog(WeightLog weightLog) {
		

		System.out.print(weightLog.getId());
		int index=0;
		
		Query query =em.createQuery("from WeightLog");
		List<WeightLog> users =  query.getResultList();
		for (WeightLog user : users) 
		{
			
				if(user.getId()!=weightLog.getId())
				{
					index=1;
					
				}	
				else
				{
					index=2;
				break;
				}
			
			
		}
		try
		{
			if(index==1)
			{
				throw new InvalidIdException();
			}
			else
			{
			wdao.updateUserWeight(weightLog);
			}
		}
		catch(InvalidIdException e)
		{
			
			System.out.println("Invalid id.");
			
		}
		return weightLog;
		
	}
@Override
	public WeightLog deleteWeightLog(WeightLog weightLog) {
			
		wdao.deleteUserWeight(weightLog);
		return weightLog;
	}

	@Override
	public WeightLog findWeightLog(WeightLog weightLog) {
		
		wdao.findUserWeight(weightLog);
		return weightLog;
		
	}
	

}
