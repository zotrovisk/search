package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Hibernate;
import sitebusca.entity.Categoria;
import sitebusca.entity.SubCategoria;


public class CategoriaDAO {

	
	public CategoriaDAO() {}
	
	public List<Categoria> getAllCategorias() {
		 List<Categoria> categorias;
			EntityManager em = Util.getEntityManagerInstance().createEntityManager();
				//Teste
	 
	        categorias = em.createQuery("select s from Categoria s", Categoria.class).getResultList();
	        em.close();	        
	        
	        return categorias;
	}
	
	public Categoria getCategoriaById(long id) {
		EntityManager em = Util.getEntityManagerInstance().createEntityManager();
	return em.getReference(Categoria.class, id); 
		
	}
	
	
	/*Consultar produtos por subCategoria*/
	public List<SubCategoria> getSubCategoriaByCategoria(String categoriaName){
		List<SubCategoria> listaSubCategorias;
		EntityManager em = Util.getEntityManagerInstance().createEntityManager();
		
		listaSubCategorias = em.createQuery("select s FROM SubCategoria s WHERE s.categoria.nomeCategoria LIKE :nomecat", SubCategoria.class)
		.setParameter("nomecat", categoriaName).getResultList();
		
		for(int i = 0 ; i < listaSubCategorias.size();i++) {
			SubCategoria subCategoria =listaSubCategorias.get(i);
			Hibernate.initialize(subCategoria.getCodCategoria());

			
		}
		
		em.close();
		
		return listaSubCategorias;
	}
	
	
}
