package com.alex.board.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.alex.board.entity.Item;
import com.alex.board.trans.PersistenceManager;

public class ItemDAO {
	
	
	public static void addItem(Item item) {
		EntityManager entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager(); 
    	EntityTransaction txn = entityManager.getTransaction(); 
    	
    	txn.begin(); 
    	
    	//persisting unpersisted categories
    	if(item.getCategories() != null)
    		item.getCategories().forEach(c -> {
    			if(c.getId() == null)
    				entityManager.persist(c);
    		});
    	//persisting seller if unpersisted
    	if(item.getSeller().getId() == null)
    		entityManager.persist(item.getSeller());
    	
    	entityManager.persist(item); 
    	txn.commit();
	}
	
	public static List<Item> getItems(){
		
		EntityManager entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager(); 
    	
		Query query = entityManager.createQuery("SELECT i FROM Item i");
    	@SuppressWarnings("unchecked")
		ArrayList<Item> resultList =  (ArrayList<Item>) query.getResultList();
    	
		return resultList;
	}
	
	public static void removeItem(String id) {
		
		EntityManager entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager(); 
    	
		Item item = (Item) entityManager.createQuery("SELECT i FROM Item i where id = " + id).getSingleResult();
		
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.remove(item);
		tx.commit();
	}
}
