package DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Hibernate;

import sitebusca.entity.Site;



public class SiteDAO {
	
	
	public SiteDAO() {}

	
	public List<Site> getAllSitesTec() {
		 List<Site> sites;
			EntityManager em = Util.getEntityManagerInstance().createEntityManager();
		 	      
	 
	        sites = em.createQuery("select s from Site s", Site.class).getResultList();

	        for(int i = 0 ; i < sites.size();i++) {
				Site site = sites.get(i);
				Hibernate.initialize(site.getProdutos());
				Hibernate.initialize(site.getRankings());
				
				
			}
	        
	        em.close();	        
	        
	        return sites;
	}
	
	
	public List<Site> getSitesByProdId(long idProd) {
		 List<Site> sites;
			EntityManager em = Util.getEntityManagerInstance().createEntityManager();
		 	      
	 
	        sites = em.createQuery("select distinct s.sites FROM SiteProduto s inner join"
	        		
	        		+ " Produto p ON s.id.produtoId = :id", Site.class)
	        		
	        		.setParameter("id",idProd).getResultList();

	        for(int i = 0 ; i < sites.size();i++) {
				Site site = sites.get(i);
				Hibernate.initialize(site.getProdutos());
				Hibernate.initialize(site.getRankings());
					
			}
	        
	        em.close();	        
	        
	        return sites;
	}
	
	public String getPrecoByProdIdAndSiteId(long idProd,long idSite) {
		 	String precoProdutoBySite;
			EntityManager em = Util.getEntityManagerInstance().createEntityManager();
		 	      
	 
			precoProdutoBySite = em.createQuery("select distinct s.precoProduto FROM SiteProduto s inner join"
	        		
	        		+ " Produto p ON s.id.produtoId = :idpr and s.id.siteId =:idsit", String.class)
	        		
	        		.setParameter("idpr",idProd).setParameter("idsit",idSite).getSingleResult();

	     			
	        
	        em.close();	        
	        
	        return precoProdutoBySite;
	}
	
	
	public Site getSiteById(long id) {
		EntityManager em = Util.getEntityManagerInstance().createEntityManager();
		
		Site site = em.getReference(Site.class, id);
		Hibernate.initialize(site.getProdutos());

	return site; 
		
	}
	

	
	
	
}
