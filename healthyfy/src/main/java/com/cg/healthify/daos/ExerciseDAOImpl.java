package com.cg.healthify.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.healthify.exceptions.NegativeIdException;
import com.cg.healthify.pojo.Exercise;


public class ExerciseDAOImpl implements ExerciseDAO {
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("nutritionapp");

	@Override
	public Exercise saveExercise(Exercise exercise) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		exercise = new Exercise(exercise.getId(), exercise.getExerciseType(), exercise.getExercisePlan());
		entityManager.getTransaction().begin();
		entityManager.persist(exercise);
		entityManager.getTransaction().commit();
		entityManager.close();
		return exercise;
	}

	@Override
	public Exercise updateExercise(Exercise exercise) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String newType = exercise.getExerciseType();
		String newPlan = exercise.getExercisePlan();
		entityManager.getTransaction().begin();
		exercise = entityManager.find(Exercise.class, exercise.getId());
		exercise.setExerciseType(newType);
		exercise.setExercisePlan(newPlan);
		entityManager.persist(exercise);
		entityManager.getTransaction().commit();
		entityManager.close();
		return exercise;
	}

	@Override
	public Exercise deleteExercise(Exercise exercise) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		exercise = entityManager.find(Exercise.class, exercise.getId());
		entityManager.remove(exercise);
		entityManager.getTransaction().commit();
		entityManager.close();
		return exercise;
	}

	@Override
	public List<Exercise> findAll() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("from Exercise");
		@SuppressWarnings("unchecked")
		List<Exercise> list=(List<Exercise>)query.getResultList();
		for(Exercise ex:list) {
			System.out.print("Exercise Id="+ex.getId()+"\n");
			System.out.print("Exercise Type="+ex.getExerciseType()+"\n");
			System.out.print("Exercise Plan="+ex.getExercisePlan()+"\n");
			System.out.println("\n");

		}
		return list;
	}


	@Override
	public Exercise findById(int id) throws NullPointerException, NegativeIdException {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		if(id<0) 
			throw new NegativeIdException();
		else {
			Exercise ex = entityManager.find(Exercise.class, id);
			if(ex!=null) {
				System.out.print("Exercise Id="+ex.getId()+"\n");
				System.out.print("Exercise Type="+ex.getExerciseType()+"\n");
				System.out.print("Exercise Plan="+ex.getExercisePlan()+"\n");
				System.out.println("\r");
				entityManager.getTransaction().commit();
				entityManager.close();
				return ex;
			}
			else 
				throw new NullPointerException();
		}

	}
}


