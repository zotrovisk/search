package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.Hibernate;

import sitebusca.entity.SubCategoria;


public class SubCategoriaDAO {
	
	public SubCategoriaDAO() {}
	
	

	public List<SubCategoria> getAllSubCategorias() {
		 List<SubCategoria> subCategorias;
			EntityManager em = Persistence.createEntityManagerFactory("searchti-db").createEntityManager();
		 	      
	 
	        subCategorias = em.createQuery("select s from SubCategoria s", SubCategoria.class).getResultList();
	        
	        for(int i = 0 ; i < subCategorias.size();i++) {
	        	SubCategoria subCategoria = subCategorias.get(i);
				Hibernate.initialize(subCategoria.getCodCategoria());

				
			}
	        
	        em.close();	        
	        
	        return subCategorias;
	}
	
	public SubCategoria getSubCategoriaById(long id) {
		EntityManager em = Util.getEntityManagerInstance().createEntityManager();
		SubCategoria subCategoria = em.getReference(SubCategoria.class, id);
		
		em.close();
		
	return subCategoria; 
		
	}

}
