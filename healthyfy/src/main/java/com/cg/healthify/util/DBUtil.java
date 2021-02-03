package com.cg.healthify.util;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
	
	public static EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPA-PU");  
    
}
