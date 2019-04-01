package com.alex.board.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.alex.board.entity.Category;
import com.alex.board.trans.PersistenceManager;

public class CategoryDAO {
	
	public static void addCategory(Category category)  {
		EntityManager entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager(); 
    	
		
		EntityTransaction txn = entityManager.getTransaction(); 
    	
    	
    	
    	txn.begin(); 
    	entityManager.persist(category); 
    	txn.commit();
	}
	

	public static List<Category> getCategories(){
		
		EntityManager entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager(); 
    	
		Query query = entityManager.createQuery("SELECT c FROM Category c");
    	@SuppressWarnings("unchecked")
		ArrayList<Category> resultList =  (ArrayList<Category>) query.getResultList();
    	
		return resultList;
	}

	public static List<Category> getListCategoriesWithListIds(String[] categories) {
		
		EntityManager entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager(); 
    	
		StringBuilder str_ids = new StringBuilder();
		for(String s : categories)
			str_ids.append(s + ", ");
		
		Query query = entityManager.createQuery("SELECT c FROM Category c where id in (" +
		str_ids.toString().substring(0, str_ids.length()-2) + ")");
    	@SuppressWarnings("unchecked")
		ArrayList<Category> resultList =  (ArrayList<Category>) query.getResultList();
    	
		return resultList;
	}
}
