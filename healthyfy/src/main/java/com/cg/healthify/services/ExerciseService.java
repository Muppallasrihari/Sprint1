package com.cg.healthify.services;

import java.util.List;

import com.cg.healthify.exceptions.NegativeIdException;
import com.cg.healthify.pojo.Exercise;

/**
 * Business logic Interface
 * @Joel Jacob
 *
 */
public interface ExerciseService {
	
	public Exercise addExercise(Exercise exercise);

	public Exercise updateExercise(Exercise exercise) throws NegativeIdException,NullPointerException;

	public Exercise deleteExercise(Exercise exercise);

	public List<Exercise> findAll();
	
	public Exercise findById(int id) throws NullPointerException, NegativeIdException;
	
	public void validateId(int id) throws NegativeIdException;

}
