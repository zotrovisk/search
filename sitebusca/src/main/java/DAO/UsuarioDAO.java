package DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Hibernate;

import sitebusca.entity.Produto;
import sitebusca.entity.Site;
import sitebusca.entity.Usuario;



public class UsuarioDAO {

	public UsuarioDAO() {}
	
	public List<Usuario> getUsuarios() {
		System.out.println("getUsuarios");
		 List<Usuario> listaProduto;
			EntityManager em = Util.getEntityManagerInstance().createEntityManager();
		 	      
	 
	        System.out.println("Recuperando os dados getUsuario:");
	        listaProduto = em.createQuery("select distinct u from Usuario u", Usuario.class).getResultList();
	        System.out.println("listaProdutos: "+listaProduto);
	        
	        for(int i = 0 ; i < listaProduto.size();i++) {
	        	Usuario usu =listaProduto.get(i);
				Hibernate.initialize(usu.getNomeUsu());
				Hibernate.initialize(usu.getSenhaUsu());

				
			}
	        
	        em.close();	        
	        
	        return listaProduto;
	}
	
}
