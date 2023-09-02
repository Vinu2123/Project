package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SavePerson {

	public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Vinnu");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	Person person=new Person();
	 person.setAge(22);
	 person.setEmail("dingarbilli@gmail.com");
	 person.setGender("male");
	 person.setName("dingri");
	 person.setPhno(9682541257l);
	 
	 Person person1=new Person();
	 person1.setAge(23);
	 person1.setEmail("udribilli@gmail.com");
	 person1.setGender("male");
	 person1.setName("udri");
	 person1.setPhno(9682541857l);
	 
	 
	 pan pan=new pan();
	 pan.setCountry("india");
	 pan.setPanno(8967452183l);
	 pan.setState("karnataka");
	 
	 pan pan1=new pan();
	 pan1.setCountry("hindustan");
	 pan1.setPanno(8967542183l);
	 pan1.setState("karunady");
	 
	 person.setPans(pan);
	 person1.setPans(pan1);
	 
	 
	 entityTransaction.begin();
	 entityManager.persist(person);
	 entityManager.persist(person1);
	 entityManager.persist(pan);
	 entityManager.persist(pan1);
	 entityTransaction.commit();
	 
	}

}