package com.cg.healthify.daos;

import com.cg.healthify.pojo.Exercise;
import com.cg.healthify.pojo.Login;

public interface ExerciseDAO {
	
    public void saveExercise(Exercise exercise,Login login);
	
	public void updateExercise(Exercise exercise);
	
	public void deleteExercise(Exercise exercise);

	 public void customerExercisePlan(Exercise exercise);

}
