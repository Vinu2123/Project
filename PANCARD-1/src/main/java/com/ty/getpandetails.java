package com.ty;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class getpandetails {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Vinnu");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query=entityManager.createQuery("seslect s from pan s");
		List<pan> l =query.getResultList();
		
		for (pan pan : l) {
			System.out.println(pan.getCountry());
			System.out.println(pan.getPid());
			System.out.println(pan.getPanno());
		}
		
}
}
