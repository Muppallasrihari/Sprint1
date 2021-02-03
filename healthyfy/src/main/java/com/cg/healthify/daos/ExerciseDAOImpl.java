package com.cg.healthify.daos;

import com.cg.healthify.pojo.Exercise;
import com.cg.healthify.pojo.Login;
import com.cg.healthify.util.DBUtil;

public class ExerciseDAOImpl extends DBUtil implements ExerciseDAO {

	@Override
	public void saveExercise(Exercise exercise, Login login) {
		exercise = new Exercise(exercise.getId(), exercise.getExerciseType(), exercise.getExercisePlan());
		em.getTransaction().begin();
		em.persist(exercise);
		System.out.println("Exercise Plan Saved.");
		em.getTransaction().commit();
	}

	@Override
	public void customerExercisePlan(Exercise exercise) {
		em.getTransaction().begin();
		exercise = em.find(Exercise.class, exercise.getId());
		System.out.println("ID:" + exercise.getId() + "\n" + "Exercise Type: " + exercise.getExerciseType() + "\n"
				+ "Exercise Plan : " + exercise.getExercisePlan());
		em.getTransaction().commit();

	}

	@Override
	public void updateExercise(Exercise exercise) {
		// TODO Auto-generated method stub
		String newType = exercise.getExerciseType();
		String newPlan = exercise.getExercisePlan();
		em.getTransaction().begin();
		exercise = em.find(Exercise.class, exercise.getId());
		exercise.setExerciseType(newType);
		exercise.setExercisePlan(newPlan);
		em.persist(exercise);
		System.out.println("Your Exercise plan is Updated...");
		em.getTransaction().commit();
	}

	@Override
	public void deleteExercise(Exercise exercise) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		exercise = em.find(Exercise.class, exercise.getId());
		em.remove(exercise);
		System.out.println("Your Current Exercise Plan is Removed");
		em.getTransaction().commit();
	}

	
}
