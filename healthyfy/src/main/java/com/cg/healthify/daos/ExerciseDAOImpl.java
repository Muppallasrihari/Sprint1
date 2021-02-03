package com.cg.healthify.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.healthify.pojo.Exercise;
import com.cg.healthify.util.DBUtil;

public class ExerciseDAOImpl extends DBUtil implements ExerciseDAO {
	
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("nutritionapp");

	@Override
	public void saveExercise(Exercise exercise) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		exercise = new Exercise(exercise.getId(), exercise.getExerciseType(), exercise.getExercisePlan());
		entityManager.getTransaction().begin();
		entityManager.persist(exercise);
		System.out.println("Exercise Plan Saved.");
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public void customerExercisePlan(Exercise exercise) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		exercise = entityManager.find(Exercise.class, exercise.getId());
		System.out.println("ID:" + exercise.getId() + "\n" + "Exercise Type: " + exercise.getExerciseType() + "\n"
				+ "Exercise Plan : " + exercise.getExercisePlan());
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Override
	public void updateExercise(Exercise exercise) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String newType = exercise.getExerciseType();
		String newPlan = exercise.getExercisePlan();
		entityManager.getTransaction().begin();
		exercise = entityManager.find(Exercise.class, exercise.getId());
		exercise.setExerciseType(newType);
		exercise.setExercisePlan(newPlan);
		entityManager.persist(exercise);
		System.out.println("Your Exercise plan is Updated...");
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public void deleteExercise(Exercise exercise) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		exercise = entityManager.find(Exercise.class, exercise.getId());
		entityManager.remove(exercise);
		System.out.println("Your Current Exercise Plan is Removed");
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	
}
