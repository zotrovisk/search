package DAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Util {

	private static EntityManagerFactory emf;
	
	public static EntityManagerFactory  getEntityManagerInstance() {
	
			if(emf == null) {
				emf = Persistence.createEntityManagerFactory("searchti-db");
			}
		
			return emf;
	}
	
	
}
