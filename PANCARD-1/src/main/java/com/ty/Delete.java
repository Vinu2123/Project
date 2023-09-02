package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Delete {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Vinnu");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Person person=entityManager.find(Person.class, 1);
		if(person!=null) {
			pan pan=entityManager.find(pan.class, 1);
			
			entityTransaction.begin();
			entityManager.remove(person);
			entityManager.remove(pan);
			entityTransaction.commit();
		}else {
			System.out.println("data is not found");
		}

	}

}
