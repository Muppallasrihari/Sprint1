package com.cg.healthify.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.healthify.daos.ExerciseDAO;
import com.cg.healthify.daos.ExerciseDAOImpl;
import com.cg.healthify.exceptions.NegativeIdException;
import com.cg.healthify.pojo.Exercise;

public class ExerciseServiceImpl implements ExerciseService {
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("nutritionapp");

	private ExerciseDAO exerciseDAO;

	public ExerciseServiceImpl() {
		exerciseDAO = new ExerciseDAOImpl();

	}
	@Override
	public Exercise addExercise(Exercise exercise) {
		exerciseDAO.saveExercise(exercise);
		return exercise;
	}

	@Override
	public Exercise updateExercise(Exercise exercise) throws NegativeIdException, NullPointerException {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Exercise ex=entityManager.find(Exercise.class, exercise.getId());
		if(exercise.getId()<0) {
			throw new NegativeIdException();
		}
		else if(ex!=null) {
			exerciseDAO.updateExercise(exercise);
			return exercise;
		}
		else {
			throw new NullPointerException();
		}
	}

	@Override
	public Exercise deleteExercise(Exercise exercise) {
		exerciseDAO.deleteExercise(exercise);
		return exercise;
	}

	@Override
	public List<Exercise> findAll() {
		exerciseDAO.findAll();
		return null;
	}

	@Override
	public Exercise findById(int id) throws NullPointerException, NegativeIdException {
		if(id<0) {
			throw new NegativeIdException();
		}
		else {
			Exercise ex=exerciseDAO.findById(id);
			return ex;
		}
	}

	@Override
	public void validateId(int id) throws NegativeIdException {
		if(id<0) {
			throw new NegativeIdException("Null Id.");
		}
	}

}
