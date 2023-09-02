package com.ty;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GetData {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Vinnu");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query=entityManager.createQuery("select s from Person s");
		List<Person> l =query.getResultList();
		
		for (Person person : l) {
			System.out.println(person.getAge());
			System.out.println(person.getId());
			System.out.println(person.getGender());
			System.out.println(person.getEmail());
			System.out.println(person.getName());
			System.out.println(person.getPhno());
		}
	}
}
