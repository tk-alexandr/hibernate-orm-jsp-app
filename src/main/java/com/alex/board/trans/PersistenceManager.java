package com.alex.board.trans;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {

	private static final PersistenceManager singleton = new PersistenceManager();
	private EntityManagerFactory emf = null;

	private void init() {
		System.out.println("Creating Entity Manager Factory");
		emf = Persistence.createEntityManagerFactory("boardPU");
	}
	
	public static PersistenceManager getInstance() {
		return singleton;
	}
	
	public EntityManagerFactory getEntityManagerFactory() {
		
		if(emf == null)
			singleton.init();
		return emf;
	}
}
