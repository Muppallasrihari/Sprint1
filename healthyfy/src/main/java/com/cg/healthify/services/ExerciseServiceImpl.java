package com.cg.healthify.services;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import com.cg.healthify.exceptions.NoRecordFoundException;
import com.cg.healthify.pojo.Exercise;
import com.cg.healthify.pojo.Login;
import com.cg.healthify.util.DBUtil;
import com.cg.healthify.daos.*;

public class ExerciseServiceImpl extends DBUtil implements ExerciseService {
	Exercise exercise = new Exercise();
	ExerciseDAOImpl exercisedao = new ExerciseDAOImpl();
	Login login = new Login();
	Scanner sc = new Scanner(System.in);

	@Override
	public Exercise addExercise(Exercise exercise) {
		int io = 0;
		try {
			Query query = em.createQuery("from Login");
			List<Login> loginm = query.getResultList();
			for (Login i : loginm) {
				if (i.getId() == exercise.getId()) {
					io++;
					break;
				}
			}
			Validate(io);
		} catch (NoRecordFoundException m) {
			System.out.println(m);
		}
		if (io == 1) {
			exercisedao.saveExercise(exercise, login);
		}
		return exercise;

	}

	
	@Override
	public Exercise updateExercise(Exercise exercise) {
		int io = 0;
		try {
			Query query = em.createQuery("from Login");
			List<Login> loginm = query.getResultList();
			for (Login i : loginm) {
				if (i.getId() == exercise.getId()) {
					io++;
					break;
				}
			}
			Validate(io);
		} catch (NoRecordFoundException m) {
			System.out.println(m);
		}
		if (io == 1) {

			exercisedao.updateExercise(exercise);
		}
		return exercise;
	}

	@Override
	public Exercise deleteExercise(Exercise exercise) {
		exercisedao.deleteExercise(exercise);
		return exercise;
	}

	@Override
	public Exercise findExerciseData(Exercise exercise) {
		int io = 0;
		try {
			Query query = em.createQuery("from Login");
			List<Login> loginm = query.getResultList();
			for (Login i : loginm) {
				if (i.getId() == exercise.getId()) {
					io++;
					break;
				}
			}
			Validate(io);
		} catch (NoRecordFoundException m) {
			System.out.println(m);
		}
		if (io == 1) {
			exercisedao.customerExercisePlan(exercise);
		}
		return exercise;
	}
	
	private void Validate(int io) throws NoRecordFoundException {
		if (io == 0) {
			throw new NoRecordFoundException("No Records Found");
		}
	}


}
