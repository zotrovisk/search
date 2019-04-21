package DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Hibernate;

import sitebusca.entity.EspecificacaoTecnica;



public class EspecificacaoTecnicaDAO {
	public EspecificacaoTecnicaDAO() {}	
	
	
	public List<EspecificacaoTecnica> getAllEspecTec() {
		 List<EspecificacaoTecnica> especificacaoTecnica;
			EntityManager em = Util.getEntityManagerInstance().createEntityManager();
		 	      
	 
	        especificacaoTecnica = em.createQuery("select s from EspecificacaoTecnica s", EspecificacaoTecnica.class).getResultList();

	        
	        em.close();	        
	        
	        return especificacaoTecnica;
	}
	
	public List<EspecificacaoTecnica> getEspecByProd(String produtoespec){
		List<EspecificacaoTecnica> listaEspecTec;
		EntityManager em = Util.getEntityManagerInstance().createEntityManager();
		
		listaEspecTec = em.createQuery("select e FROM EspecificacaoTecnica e WHERE e.prodespec.nomeProd LIKE :nomeprod", EspecificacaoTecnica.class)
		.setParameter("nomeprod", produtoespec).getResultList();
		
		for(int i = 0 ; i < listaEspecTec.size();i++) {
			EspecificacaoTecnica especTec =listaEspecTec.get(i);
			Hibernate.initialize(especTec.getProdutos());

		}
		
		em.close();
		
		return listaEspecTec;
	}
	
	public EspecificacaoTecnica getEspecificacaoTecnicaById(long id) {
		EntityManager em = Util.getEntityManagerInstance().createEntityManager();
		EspecificacaoTecnica espectTec = em.getReference(EspecificacaoTecnica.class, id);
		
		
        em.close();	        

	return espectTec; 
		
	}
	

	
	
}
