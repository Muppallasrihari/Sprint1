package com.cg.healthify.services;

import com.cg.healthify.pojo.Exercise;

public interface ExerciseService {
	
	public Exercise addExercise(Exercise exercise);

	public Exercise updateExercise(Exercise exercise);

	public Exercise deleteExercise(Exercise exercise);

	public Exercise findExerciseData(Exercise exercise);

}
