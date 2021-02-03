package com.cg.healthify.daos;

import com.cg.healthify.pojo.WeightLog;

public interface WeightLogDAO {

	public WeightLog addUserWeight(WeightLog weight);
	public WeightLog updateUserWeight(WeightLog weight);
	public WeightLog deleteUserWeight(WeightLog weight);
	public WeightLog findUserWeight(WeightLog weight);

}
