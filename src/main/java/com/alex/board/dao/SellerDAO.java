package com.alex.board.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.alex.board.entity.Seller;
import com.alex.board.trans.PersistenceManager;

public class SellerDAO {

	public static void addSeller(Seller seller) {
		EntityManager entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager(); 
    	EntityTransaction txn = entityManager.getTransaction(); 
    	txn.begin(); 
    	entityManager.persist(seller); 
    	txn.commit();
		
	}
	
	public static List<Seller> getSellers() {
		
		EntityManager entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager(); 
    	
		Query query = entityManager.createQuery("SELECT s FROM Seller s");
    	@SuppressWarnings("unchecked")
		ArrayList<Seller> resultList =  (ArrayList<Seller>) query.getResultList();
    	
		return resultList;
	}
	
	public static Seller getSellerWithId(String id) {
		
		EntityManager entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager(); 
    	
		Query query = entityManager.createQuery("SELECT s FROM Seller s where id = " + id);
		Seller seller =   (Seller) query.getSingleResult();
		
		return seller;
	}
}
